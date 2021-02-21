package CH10_Sorting_Searching.Search;

public class BinarySearch {
    int binarySearchIterative(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low+high) / 2;
            if (a[mid] < x) {
                // search in the right half of the array
                low = mid+1;
            } else if (a[mid] > x){
                // search in the left half of the array
                high = mid-1;
            } else {
                // mid == x, found x, now return its index
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Testing basic binary search...");
        int[] unsortedArr = new int[]{37,4,15,2,1,5,7,17,6,8};
        int[] sortedArr = new int[]{1,2,3,4,6,7,8,15,17,37};
        System.out.println("input sorted array is: " );



    }
}