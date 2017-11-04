package RegExp;

import java.io.*;
import java.util.Scanner;

public class FileProcessor {

    public  String getTextFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder("");
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public  void clearFile(File fileDirectory, String fileName) {
        File file = new File(fileDirectory, fileName);

        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTextToFile(File fileDirectory, String fileName, String text) {
        File file = new File(fileDirectory, fileName);

        try (FileWriter fileWriter = new FileWriter(file)){
               fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
