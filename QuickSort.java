/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;
import java.util.Random;
/**
 *
 * @author 96653
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
 Random rand = new Random();
    int[] numbers = new int[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100);
    }

    System.out.println("Before:");
    printArray(numbers);

    quicksort(numbers);

    System.out.println("\nAfter:");
    printArray(numbers);
        
    }
    
private static void quicksort(int[] array) {
    quicksort(array, 0, array.length - 1);
  }

  private static void quicksort(int[] array, int lowIndex, int highIndex) {

    if (lowIndex >= highIndex) {
      return;
    }

    int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, highIndex);

    int leftPointer = partition(array, lowIndex, highIndex, pivot);

    quicksort(array, lowIndex, leftPointer - 1);
    quicksort(array, leftPointer + 1, highIndex);

  }

  private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
    int leftPointer = lowIndex;
    int rightPointer = highIndex - 1;

    while (leftPointer < rightPointer) {

      while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
        leftPointer++;
      }

      while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
        rightPointer--;
      }

      swap(array, leftPointer, rightPointer);
    }
    
   
    if(array[leftPointer] > array[highIndex]) {
      swap(array, leftPointer, highIndex);
    }
    else {
      leftPointer = highIndex;
    }
    
    return leftPointer;
  }

  private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }
}
     
}




















package javaapplication1;

import java.util.Arrays;
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
         System.out.println("before");
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(n );
            System.out.println(result[i]);
        }
         
        return result;
    }

    public static int[] generateSortedIncreasingOrderNumbers(int n) {
        int[] result = new int[n];
         System.out.println("before");
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
         System.out.println(result[i]);
            
        }
        return result;
    }

    public static int[] generateSortedDecreasingOrderNumbers(int n) {
        int[] result = new int[n];
      System.out.println("before");
        for (int i = 0; i < result.length; i++) {
            result[i] = n - i;
            System.out.println(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        int n = 10;
        int numbers[];
        long start, end;
        float sec;

        numbers = generateRandomNumbers(n);
        start = System.currentTimeMillis();
         System.out.println(numbers);
         System.out.println("after");
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
       
        System.out.println("Time taken to sort " + n + " random generated numbers = " + sec + " seconds");

        numbers = generateSortedIncreasingOrderNumbers(n);
        start = System.currentTimeMillis();
        selectionSort(numbers);
        System.out.println("after");
        System.out.println(Arrays.toString(numbers));
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println("Time taken to sort " + n + " sorted increasing order numbers = " + sec + " seconds");

        numbers = generateSortedDecreasingOrderNumbers(n);
        start = System.currentTimeMillis();
        selectionSort(numbers);
        System.out.println("after");
        System.out.println(Arrays.toString(numbers));
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println("Time taken to sort " + n + " sorted decreasing order numbers = " + sec + " seconds");
      
    }

}































