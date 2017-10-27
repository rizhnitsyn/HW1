package Robots.Details;

import Robots.GarbageDump;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FabricOfDetails implements Runnable {
    private Random generator = new Random();
    private int totalDetailsProduced = 0;
    private CyclicBarrier barrier;

    public FabricOfDetails(CyclicBarrier barrier) {
        this.barrier = barrier;
        throwOutDetailsOnDump(20);
    }

    public int getTotalDetailsProduced() {
        return totalDetailsProduced;
    }

    @Override
    public void run() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        int numberOfRandomDetails = generator.nextInt(4) + 1;
        throwOutDetailsOnDump(numberOfRandomDetails);
    }

    private void throwOutDetailsOnDump(int detailsCount) {
        for (int i = 0; i < detailsCount; i++) {
            DetailForRobot detail = produceOneRandomDetail();
            synchronized (GarbageDump.listOfDetailsOnDump()) {
                GarbageDump.listOfDetailsOnDump().add(detail);
            }
        }
        totalDetailsProduced += detailsCount;
        System.out.println("Fabric produced " + detailsCount + " new details");
    }

    private DetailForRobot produceOneRandomDetail() {
        int partNumber = generator.nextInt(DetailName.values().length);
        return createDetail(DetailName.values()[partNumber]);
    }

    private DetailForRobot createDetail(DetailName detailName) {
        if (detailName == DetailName.BODY) {
            return new RobotBody();
        } else if (detailName == DetailName.HEAD) {
            return new RobotHead();
        } else if (detailName == DetailName.LEFT_HAND) {
            return new RobotLeftHand();
        } else if (detailName == DetailName.RIGHT_HAND) {
            return new RobotRightHand();
        } else if (detailName == DetailName.LEFT_LEG) {
            return new RobotLeftLeg();
        } else if (detailName == DetailName.RIGHT_LEG) {
            return new RobotRightLeg();
        } else if (detailName == DetailName.RAM) {
            return new RobotRAM();
        } else if (detailName == DetailName.HDD) {
            return new RobotHDD();
        } else if (detailName == DetailName.CPU) {
            return new RobotCPU();
        } else {
            return null;
        }
    }
}
