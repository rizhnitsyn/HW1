package Robots.Details;

public class RobotRightHand extends DetailForRobot {
    private static int sequence = 0;

    public RobotRightHand() {
        sequence++;
        super.setSerNo("RH" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.RIGHT_HAND;
    }
}
