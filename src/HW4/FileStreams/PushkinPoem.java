package HW4.FileStreams;

import java.io.*;
import java.util.*;

public class PushkinPoem {
    private static final File FILE_DIRECTORY = new File("src" + File.separator + "HW4" + File.separator + "FileStreams");

    public static void main(String[] args) {
        File file = new File(FILE_DIRECTORY,"pushkin.txt");
        Map<Character, Integer> map = new TreeMap<>();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    addToMap(map, line.toLowerCase().charAt(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printMap(map);
        writeToFile(map);
    }

    public static void writeToFile(Map<Character, Integer> map) {
        File file = new File(FILE_DIRECTORY,"pushkinChars.txt");
        try (FileWriter fileWriter = new FileWriter(file)){
            for (Map.Entry<Character, Integer> pair : map.entrySet()) {
                fileWriter.write( pair.getKey() + " - " + pair.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToMap(Map<Character, Integer> map,  char ch) {
        if (Character.isAlphabetic(ch)) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
    }

    public static void printMap(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
