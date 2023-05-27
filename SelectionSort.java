
package javaapplication1;

import java.util.Random;

public class SelectionSort {

    public static int[] selectionSort(int[] input) {
        int n = input.length;
        for (int j = 0; j < n - 1; j++) {
            int smallest = j;
            for (int i = j + 1; i < n; i++) {
                if (input[i] < input[smallest]) {
                    smallest = i;
                }
            }
            int temp = input[j];
            input[j] = input[smallest];
            input[smallest] = temp;
        }
        return input;
    }

    public static int[] generateRandomNumbers(int n) {
        int[] result = new int[n];
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(n * 10);
        }
        return result;
    }

    public static int[] generateSortedIncreasingOrderNumbers(int n) {
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static int[] generateSortedDecreasingOrderNumbers(int n) {
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = n - i;
        }
        return result;
    }

    public static void main(String[] args) {

        int n = 10000;
        int numbers[];
        long start, end;
        float sec;

        numbers = generateRandomNumbers(n);
        start = System.currentTimeMillis();
        selectionSort(numbers);
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println("Time taken to sort " + n + " random generated numbers = " + sec + " seconds");

        numbers = generateSortedIncreasingOrderNumbers(n);
        start = System.currentTimeMillis();
        selectionSort(numbers);
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println("Time taken to sort " + n + " sorted increasing order numbers = " + sec + " seconds");

        numbers = generateSortedDecreasingOrderNumbers(n);
        start = System.currentTimeMillis();
        selectionSort(numbers);
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println("Time taken to sort " + n + " sorted decreasing order numbers = " + sec + " seconds");

    }

}