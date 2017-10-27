package Robots.Details;

public class RobotLeftLeg extends DetailForRobot {
    private static int sequence = 0;

    public RobotLeftLeg() {
        sequence++;
        super.setSerNo("LL" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.LEFT_LEG;
    }
}
