package HW2.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Linearize {
    public static void main(String[] args) {
        int[][] arrayForLinearize = getArrayOfRandomLength();
        System.out.println(Arrays.deepToString(arrayForLinearize));
        System.out.println(Arrays.toString(linearize1(arrayForLinearize))); //use merge as well as in third task
        System.out.println(Arrays.toString(linearize2(arrayForLinearize))); //another method
    }

    public static int[][] getArrayOfRandomLength() {
        Random random = new Random();
        int[][] array = new int[random.nextInt(10)][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[random.nextInt(5)];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        return array;
    }

    public static int[] linearize1(int[][] array) {
        return mergeAnyAmountOfArrays(array);
    }

    public static int[] linearize2(int[][] array) {
        return mergeArrays(array);
    }

    public static int[] mergeArrays(int[]...array){
        int totalLength = 0;
        for (int[] anArray : array) {
            totalLength += anArray.length;
        }
        int[] newArray = new int[totalLength];
        int k = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++, k++) {
                newArray[k] = array[i][j];
            }
        }
        return newArray;
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
}
