package CH10_Sorting_Searching.Sorts;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int middle = (left + right) / 2;
        int pivot = arr[middle];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("Testing Quick Sort implementation...");
        int[] unsorted = {1,4,5,2,8,9};
        System.out.println("before sorting, array is: " + Arrays.toString(unsorted));
        quickSort(unsorted, 0, unsorted.length-1);
        System.out.println("after sorting, array is now: " + Arrays.toString(unsorted));
    }
}