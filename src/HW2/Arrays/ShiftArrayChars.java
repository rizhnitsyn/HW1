package HW2.Arrays;

import java.util.Arrays;
import java.util.Random;

public class ShiftArrayChars {
    public static void main(String[] args) {
        int[] randomNumbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(randomNumbers));
        System.out.println(Arrays.toString(shiftChars(randomNumbers)));
    }

    public static int[] shiftChars(int[] array) {
        int currentValue;
        int nextValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                currentValue = nextValue;
                nextValue = array[i + 1];
                array[i + 1] = currentValue;
            } else {
                array[0] = nextValue;
            }
        }
        return array;
    }
}
