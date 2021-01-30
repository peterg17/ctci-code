package CH10_Sorting_Searching.Sorts;

import java.util.Arrays;

public class SelectionSort {

    /**
     * Selection Sort:
     * Linear scan through array, find smallest
     * and swap with the front of the array. Continue until get to the end of array
     *
     * Time: O(n**2)
     * Space: O(1)
     *
     */

    public static void sort(int[] input, int start) {
        if (start == input.length-1) {
            return;
        }
        int min = input[start];
        int minIdx = start;
        for (int i=start; i < input.length; i++) {
            int val = input[i];
            if (val < min) {
                min = val;
                minIdx = i;
            }
        }
        if (minIdx != start) {
            // swap current value with start of array
            input[minIdx] = input[start];
            input[start] = min;
            sort(input, start+1);
        }
    }


    public static void main(String[] args) {
        System.out.println("Testing selection sort implementation...");
        int[] unsortedArr = new int[]{37,4,15,2,1,5,7,17,6,8};
        System.out.println("Unsorted array is: " + Arrays.toString(unsortedArr));
        sort(unsortedArr, 0);
        System.out.println("Sorted array is: " + Arrays.toString(unsortedArr));
    }
}