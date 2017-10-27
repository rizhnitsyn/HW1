package Robots.Details;

public class RobotHead extends DetailForRobot {
    private static int sequence = 0;

    public RobotHead() {
        sequence++;
        super.setSerNo("H" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.HEAD;
    }
}
