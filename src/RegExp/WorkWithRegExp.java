package RegExp;

import java.io.File;

public class WorkWithRegExp {
    private static final File FILE_DIRECTORY = new File("src" + File.separator + "RegExp");

    public static void main(String[] args) {
        File file = new File(FILE_DIRECTORY,"logfile.txt");
        FileProcessor fileProcessor = new FileProcessor();
        String textFromFile = fileProcessor.getTextFromFile(file);

        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.addLogFileToAnalyzer(textFromFile);
        logAnalyzer.createTimeIntervalLog();
        logAnalyzer.createLogsByActivities();

        fileProcessor.clearFile(FILE_DIRECTORY, "timeIntervalLog.txt");
        fileProcessor.clearFile(FILE_DIRECTORY, "logByActivity.txt");
        fileProcessor.clearFile(FILE_DIRECTORY, "detailedLecturesLog.txt");

        fileProcessor.writeTextToFile(FILE_DIRECTORY, "timeIntervalLog.txt", logAnalyzer.getTimeIntervalLog());
        fileProcessor.writeTextToFile(FILE_DIRECTORY, "logByActivity.txt", logAnalyzer.getLogByActivity());
        fileProcessor.writeTextToFile(FILE_DIRECTORY, "detailedLecturesLog.txt", logAnalyzer.getDetailedLecturesLog());

        logAnalyzer.clearBuffer();
    }
}
