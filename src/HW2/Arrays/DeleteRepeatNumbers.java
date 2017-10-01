package HW2.Arrays;

import java.util.Arrays;
import java.util.Random;

public class DeleteRepeatNumbers {
    public static void main(String[] args) {
        int[] randomNumbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(10);
        }
        System.out.println("Array[10] of random numbers: " + Arrays.toString(randomNumbers));
        System.out.println("Using 2 loops: " + Arrays.toString(deleteRepeatedNumbersFromArrayMethod1(randomNumbers)));
        System.out.println("Using sort of source array: " + Arrays.toString(deleteRepeatedNumbersFromArrayMethod2(randomNumbers)));
    }

    public static int[] deleteRepeatedNumbersFromArrayMethod1(int[] array) {
        int[] idxArray = new int[array.length];
        boolean isRepetedNumber = false;
        int newLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (idxArray[i] == 1) {
                continue;
            }
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    idxArray[j] = 1;
                    isRepetedNumber = true;
                }
            }
            if (isRepetedNumber) {
                idxArray[i] = 1;
            } else {
                newLength++;
            }
            isRepetedNumber = false;
        }

        int[] newArray = new int[newLength];
        int cnt = 0;
        for (int i = 0; i < idxArray.length; i++) {
            if (idxArray[i] == 0) {
                newArray[cnt] = array[i];
                cnt++;
            }
        }
        return newArray;
    }

    public static int[] deleteRepeatedNumbersFromArrayMethod2(int[] array) {
        Arrays.sort(array);
        int[] newArray = new int[array.length];
        int returnArrayLength = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i == 0 && array[i] != array[i + 1]) || (i == (array.length - 1) && array[i] != array[i - 1])) {
                newArray[returnArrayLength] = array[i];
                returnArrayLength++;
            } else if (i != 0 && i != (array.length - 1) && array[i] != array[i + 1] && array[i] != array[i - 1]) {
                newArray[returnArrayLength] = array[i];
                returnArrayLength++;
            }
        }
        return Arrays.copyOf(newArray, returnArrayLength);
    }
}
