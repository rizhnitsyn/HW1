package HW4.FileStreams;

import java.io.*;
import java.util.*;

public class FileWithRandomNumbers {
    private static final File FILE_DIRECTORY = new File("src" + File.separator + "HW4" + File.separator + "FileStreams");

    public static void main(String[] args) {
        File file = new File(FILE_DIRECTORY,"randomNumbers.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> integerList = generateListWithrandomNumbers();
        System.out.println(integerList.toString());
        writeToFile(integerList, file);
        integerList = readNumbersFromFile(file);
        Collections.sort(integerList);
        System.out.println(integerList);
        writeToFile(integerList, file);

    }
    public static List<Integer> readNumbersFromFile(File file) {
        List<Integer> integerList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static List<Integer> generateListWithrandomNumbers() {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            integerList.add(random.nextInt(1000));
        }
        return integerList;
    }

    public static void writeToFile(List<Integer> integerList, File file) {
        try (FileWriter fileWriter = new FileWriter(file)){
            for (Integer anIntegerList : integerList) {
                fileWriter.write(String.valueOf(anIntegerList) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
