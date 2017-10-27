package Robots.Details;

public class RobotCPU extends DetailForRobot {
    private static int sequence = 0;

    public RobotCPU() {
        sequence++;
        super.setSerNo("CP" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.CPU;
    }
}
