package Robots.Details;

import java.util.Set;
import java.util.stream.Collectors;

public class Robot {
    private String name;
    private Set<DetailForRobot> partsOfRobot;

    public Robot(String name, Set<DetailForRobot> partsOfRobot) {
        this.name = name;
        this.partsOfRobot = partsOfRobot;
    }

    @Override
    public String toString() {
        return (name + " consists from parts: " + (partsOfRobot.stream()
                 .map(a -> a.getDetailName() + "[" + a.getSerNo() + "]")
                 .collect(Collectors.joining(", "))));
    }
}
