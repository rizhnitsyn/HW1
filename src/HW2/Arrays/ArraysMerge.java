package HW2.Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysMerge {
    public static void main(String[] args) {
        int[] firstArray = getArrayOfRandomLength();
        int[] secondArray = getArrayOfRandomLength();
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
        System.out.println(Arrays.toString(mergeAnyAmountOfArrays(firstArray, secondArray)));
    }

    public static int[] mergeAnyAmountOfArrays(int[]...array){
        int totalLength = 0;
        for (int[] anArray : array) {
            totalLength += anArray.length;
        }
        int[] newArray = new int[totalLength];
        int secondDimensionIdx = 0;
        for (int i = 0; i < newArray.length; secondDimensionIdx++) {
            for (int j = 0; j < array.length ; j++) {
                if (array[j].length - 1 >= secondDimensionIdx) {
                    newArray[i] = array[j][secondDimensionIdx];
                    i++;
                }
            }
        }
        return newArray;
    }

    public static int[] getArrayOfRandomLength() {
        Random random = new Random();
        int[] array = new int[random.nextInt(10)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
        return array;
    }
}
