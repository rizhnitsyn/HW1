package Robots;

import Robots.Details.DetailForRobot;
import java.util.ArrayList;
import java.util.List;

public final class GarbageDump {
    private static final List<DetailForRobot> detailsOnDump = new ArrayList<>(20);

    private GarbageDump(){}

    public static List<DetailForRobot> listOfDetailsOnDump() {
        return detailsOnDump;
    }
}
