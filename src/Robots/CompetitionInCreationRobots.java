package Robots;

import Robots.Details.DetailForRobot;
import Robots.Details.FabricOfDetails;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompetitionInCreationRobots {
    private static final int NIGHT_COUNT = 100;
    private static final int LABS_COUNT = 2;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(LABS_COUNT + 1);
    private static ExecutorService threadPool = Executors.newFixedThreadPool(LABS_COUNT + 1);
    private static FabricOfDetails fabricOfDetails = new FabricOfDetails(cyclicBarrier);
    private static List<GarbageWorker> workerList = new ArrayList<>();
    private static List<Laboratory> laboratoryList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < LABS_COUNT; i++) {
            laboratoryList.add(new Laboratory("S.T.A.R.Labs" + (i + 1)));
            workerList.add(new GarbageWorker("Worker" + (i + 1), cyclicBarrier));
        }
        try {
            simulateNights();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        printResults();
    }

    private static void simulateNights() throws ExecutionException, InterruptedException {
        for (int i = 0; i < NIGHT_COUNT; i++) {
            System.out.println("NIGHT: " + (i + 1));

            threadPool.execute(fabricOfDetails);
            List<Future<List<DetailForRobot>>> futureList = workerList.stream()
                    .map(threadPool::submit)
                    .collect(Collectors.toList());

            for (int j = 0; j < LABS_COUNT; j++) {
                List<DetailForRobot> detailsList = futureList.get(j).get();
                laboratoryList.get(j).placeDetailsInLaboratory(detailsList);
            }

            laboratoryList.forEach(Laboratory::createRobots);
            Thread.sleep(100);
            System.out.println("Rests of details on Dump: " +GarbageDump.listOfDetailsOnDump().size());
            System.out.println("END OF NIGHT");
            System.out.println();
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.DAYS);
    }

    private static void printResults() {
        System.out.println("FabricOfDetails produced: " + fabricOfDetails.getTotalDetailsProduced() + " details");
        System.out.println("Details remained on the garbageDump: " + GarbageDump.listOfDetailsOnDump().size() + " details");
        System.out.println();

        laboratoryList.forEach(laboratory -> {
            System.out.println(laboratory.getName() + " collected " + laboratory.getTotalDetailsCollected() + " details, rests of the details in the laboratory: ");
            laboratory.getMapOfDetailsInLaboratory()
                    .forEach((detailName, detailList) -> System.out.print(detailName + ": " + detailList.size() + ". "));
            System.out.println();
            System.out.println("Total Robots produced: " + laboratory.getRobotList().size());
            System.out.println();});

        printWinner();
        System.out.println();
        System.out.println("LIST OF PRODUCED ROBOTS:");
         laboratoryList.stream()
                 .map(Laboratory::getRobotList)
                 .flatMap(Collection::stream)
                 .forEach(System.out::println);
    }

    private static void printWinner() {
        int maxRobotsCount = laboratoryList.stream()
                .mapToInt(laboratory -> laboratory.getRobotList().size())
                .max().orElse(0);
        if (maxRobotsCount == 0) {
            System.out.println("No robots were produced. No Winner");
            return;
        }

        System.out.println("WINNER: " + laboratoryList.stream()
                .filter(laboratory -> laboratory.getRobotList().size() == maxRobotsCount)
                .map(Laboratory::getName)
                .collect(Collectors.joining(", ")));
    }
}
