package CH10_Sorting_Searching.Sorts;

import java.util.Arrays;

public class MergeSort {
    public static void mergesort(int[] array) {
        mergesort(array, new int[array.length], 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] temp, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return; // the indices need to be ordered correctly
        }
        int middle = (startIdx + endIdx) / 2;
        mergesort(array, temp, startIdx, middle);
        mergesort(array, temp, middle+1, endIdx);
        // actually merges the elements themselves
        mergeHalves(array, temp, startIdx, endIdx);
    }

    public static void mergeHalves(int[] array, int[] temp, int startIdx, int endIdx) {
        int left = startIdx;
        int middle = (startIdx + endIdx) / 2;
        int right = middle + 1;
        int currIdx = startIdx;
        while (left <= middle && right <= endIdx) {
            if (array[left] <= array[right]) {
                temp[currIdx] = array[left];
                left++;
            } else {
                temp[currIdx] = array[right];
                right++;
            }
            currIdx++;
        }
//        for (int i=0; i < array.length; i++) {
//            array[i] = temp[i];
//        }
        System.arraycopy(array, left, temp, currIdx, middle - left + 1);
        System.arraycopy(array, right, temp, currIdx, endIdx - right + 1);
        System.arraycopy(temp, startIdx, array, startIdx, endIdx-startIdx+1);
    }

    public static void main(String[] args) {
        System.out.println("Testing merge sort...");
        int[] unsorted = {1,4,5,2,8,9};
        System.out.println("before sorting, array is: " + Arrays.toString(unsorted));
        mergesort(unsorted);
        System.out.println("after sorting, array is now: " + Arrays.toString(unsorted));
    }
}
