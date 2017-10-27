package Robots.Details;

public class RobotBody extends DetailForRobot {
    private static int sequence = 0;

    public RobotBody() {
        sequence++;
        super.setSerNo("BD" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.BODY;
    }
}
