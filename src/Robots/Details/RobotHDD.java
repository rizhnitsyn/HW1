package Robots.Details;

public class RobotHDD extends DetailForRobot {
    private static int sequence = 0;

    public RobotHDD() {
        sequence++;
        super.setSerNo("HD" + sequence);
    }

    @Override
    public DetailName getDetailName() {
        return DetailName.HDD;
    }
}
