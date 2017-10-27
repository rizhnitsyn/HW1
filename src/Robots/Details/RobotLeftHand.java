package Robots.Details;

public class RobotLeftHand extends DetailForRobot {
    private static int sequence = 0;

    public RobotLeftHand() {
        sequence++;
        super.setSerNo("LH" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.LEFT_HAND;
    }
}
