package Robots;

import Robots.Details.DetailForRobot;
import Robots.Details.DetailName;
import Robots.Details.Robot;

import java.util.*;
import java.util.stream.Collectors;

public class Laboratory {
    private String name;
    private int totalDetailsCollected;
    private List<Robot> robotList = new ArrayList<>();
    private HashMap<DetailName,List<DetailForRobot>> mapOfDetailsInLaboratory;

    public Laboratory(String name) {
        this.name = name;
        this.mapOfDetailsInLaboratory = Arrays.stream(DetailName.values())
                .collect(HashMap<DetailName, List<DetailForRobot>>::new, (map, detailName) -> map.put(detailName, new ArrayList<>()), HashMap::putAll);
    }

    public String getName() {
        return name;
    }

    public int getTotalDetailsCollected() {
        return totalDetailsCollected;
    }

    public List<Robot> getRobotList() {
        return robotList;
    }

    public HashMap<DetailName,List<DetailForRobot>> getMapOfDetailsInLaboratory() {
        return mapOfDetailsInLaboratory;
    }

    public void placeDetailsInLaboratory(List<DetailForRobot> collectedDetails) {
        collectedDetails
                .forEach(detail -> mapOfDetailsInLaboratory.get(detail.getDetailName()).add(detail));
        totalDetailsCollected += collectedDetails.size();
    }

    private boolean checkOpportunityToCreateRobot() {
        return mapOfDetailsInLaboratory.values().stream()
                .filter(a -> a.size() == 0)
                .count() == 0;
    }

    public void createRobots() {
        while (checkOpportunityToCreateRobot()) {
            Set<DetailForRobot> setOfDetails = mapOfDetailsInLaboratory.values().stream()
                    .map(detailList -> detailList.get(0))
                    .collect(Collectors.toSet());
            Robot robot = new Robot("Produced by: " + name + ", Robot_" + (robotList.size() + 1), setOfDetails);
            robotList.add(robot);
            mapOfDetailsInLaboratory.values()
                    .forEach(detailList -> detailList.remove(0));
            System.out.println(robot);
        }
    }
}
