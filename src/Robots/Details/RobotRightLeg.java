package Robots.Details;

public class RobotRightLeg extends DetailForRobot {
    private static int sequence = 0;

    public RobotRightLeg() {
        sequence++;
        super.setSerNo("RL" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.RIGHT_LEG;
    }
}
