package RegExp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogAnalyzer {
    private String[] scheduleForDay;
    private Map<String, Integer> activityMap = new HashMap<>();
    private Map<String, Integer> detailedLecturesMap = new HashMap<>();
    private String timeIntervalLog;
    private String logByActivity;
    private String detailedLecturesLog;
    private Matcher matcher;
    private StringBuilder logBuilder = new StringBuilder();

    public void addLogFileToAnalyzer(String logFile) {
        scheduleForDay = logFile.split("\\s{2}");
    }

    public String getTimeIntervalLog() {
        return timeIntervalLog;
    }

    public String getLogByActivity() {
        return logByActivity;
    }

    public String getDetailedLecturesLog() {
        return detailedLecturesLog;
    }

    private void setPattern(String textToParse, String regExpPattern) {
        Pattern pattern = Pattern.compile(regExpPattern);
        matcher = pattern.matcher(textToParse);
    }

    private void clearLogBuilder() {
        logBuilder.setLength(0);
    }

    public void clearBuffer() {
        timeIntervalLog = null;
        logByActivity = null;
        detailedLecturesLog = null;
        scheduleForDay = null;
    }

    public void createTimeIntervalLog() {
        clearLogBuilder();
        for (String oneDayLog: scheduleForDay) {
            setPattern(oneDayLog, "(\\d{2}:\\d{2})\\s(\\D+)");
            logBuilder.append(transformToTimeIntervalLog()).append("\n");
        }
        timeIntervalLog = logBuilder.toString();
    }

    private String transformToTimeIntervalLog() {
        StringBuilder stringBuilder = new StringBuilder();
        int activitiesCount = 0;
        String currentActivity = "";
        String startTime = "";
        while (matcher.find()) {
            if (activitiesCount != 0) {
                stringBuilder
                        .append(startTime)
                        .append("-")
                        .append(matcher.group(1))
                        .append(" ")
                        .append(currentActivity)
                        .append("\n");
            }
            activitiesCount++;
            startTime = matcher.group(1);
            currentActivity = matcher.group(2);
        }
        return stringBuilder.toString();
    }

    public void createLogsByActivities() {
        clearLogBuilder();
        int dayNumber = 0;
        for (String oneDayLog: scheduleForDay) {
            dayNumber++;
            setPattern(oneDayLog, "(\\d{2}:\\d{2})\\s(\\D+)");
            String oneDayIntervalLog = transformToTimeIntervalLog();
            setPattern(oneDayIntervalLog, "\\s*(\\d{2}):(\\d{2})-(\\d{2}):(\\d{2})\\s(\\D+)");
            transformToLogsByActivity();
            logBuilder.append("DAY: ")
                    .append(dayNumber)
                    .append("\n")
                    .append(convertMapToString(activityMap))
                    .append("\n")
                    .append("\n");
            activityMap.clear();
        }
        logByActivity = logBuilder.toString();
        detailedLecturesLog = convertMapToString(detailedLecturesMap);
        detailedLecturesMap.clear();
    }

    private String checkForLection(String initialActivityName) {
        return Arrays.stream(Lections.values())
                        .map(Descriable::getDescription)
                        .filter(a -> a.equals(initialActivityName))
                        .map(a -> "Лекции")
                        .collect(Collectors.joining(""));
    }

    private void putToMap(String activityName, int timeInterval, Map<String, Integer> map) {
        if (map.containsKey(activityName)) {
            map.put(activityName, map.get(activityName) + timeInterval);
        } else {
            map.put(activityName, timeInterval);
        }
    }

    private String convertMapToString(Map<String, Integer> map) {
        int totalMinutes = map.values().stream()
                .mapToInt(a -> a)
                .sum();
        return  map.entrySet().stream()
                .map(entry -> entry.getKey()  + ": " + entry.getValue() + " минут " + Math.round((((double) entry.getValue() / totalMinutes)) * 100) + "%")
                .collect(Collectors.joining("\n"));
    }

    private void transformToLogsByActivity() {
        while (matcher.find()) {
            int timeInterval = (Integer.parseInt(matcher.group(3)) - Integer.parseInt(matcher.group(1))) * 60
                    + (Integer.parseInt(matcher.group(4)) - Integer.parseInt(matcher.group(2)));

            String initialActivityName = matcher.group(5).trim();
            String currentActivityName = checkForLection(initialActivityName);
            if (!currentActivityName.equals("Лекции")) {
                currentActivityName = initialActivityName;
            } else {
                putToMap(initialActivityName, timeInterval, detailedLecturesMap);
            }
            putToMap(currentActivityName, timeInterval, activityMap);
        }
    }
}
