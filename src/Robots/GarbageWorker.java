package Robots;

import Robots.Details.DetailForRobot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class GarbageWorker implements Callable<List<DetailForRobot>> {
    private String name;
    private int collectingPower;
    private Random generator = new Random();
    private List<DetailForRobot> collectedDetails = new ArrayList<>();
    private CyclicBarrier barrier;

    public GarbageWorker(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public List<DetailForRobot> call()  {
        clearBagOfWorker();
        setCollectingPower();
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        collectDetailsFromGarbageDump();
        System.out.println(name + " collected " + collectedDetails.size() + " details");
        return collectedDetails;
    }

    private void clearBagOfWorker() {
        collectedDetails.clear();
    }

    private void setCollectingPower() {
        this.collectingPower = generator.nextInt(4) + 1;
    }

    private void collectDetailsFromGarbageDump() {
        for (int i = 0; i < collectingPower; i++) {
            DetailForRobot detailFromDump = getRandomDetailFromDump();
            if (detailFromDump != null) {
                collectedDetails.add(detailFromDump);
            }
        }
    }

    private DetailForRobot getRandomDetailFromDump() {
        DetailForRobot detailForRobot = null;
        List<DetailForRobot> detailsOnDump = GarbageDump.listOfDetailsOnDump();
        synchronized (GarbageDump.listOfDetailsOnDump()) {
            int dumpSize = detailsOnDump.size();
            if (dumpSize > 0) {
                int indexOfFoundDetail = generator.nextInt(dumpSize);
                detailForRobot = detailsOnDump.get(indexOfFoundDetail);
                detailsOnDump.remove(indexOfFoundDetail);
            }
        }
        return detailForRobot;
    }


}
