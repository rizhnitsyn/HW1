package Robots.Details;

public class RobotRAM extends DetailForRobot {
    private static int sequence = 0;

    public RobotRAM() {
        sequence++;
        super.setSerNo("RM" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.RAM;
    }
}
