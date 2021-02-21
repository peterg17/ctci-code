package CH01_Arrays.MinAmplitude;

import java.util.Arrays;

public class MinAmp {

    private static int minAmplitude(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= k-1) return 0;
        int ans = nums[n-1]-nums[0];
        for(int i = 0, j = n-k; j < n; i++, j++) {
            ans = Math.min(ans, nums[j]-nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Testing min amplitude...");
        int[] arr1 = {3,4,1,3,9,8};
        System.out.println("getting min amplitude for array 1: " +
                Arrays.toString(arr1) + " with k=4");
        int amp1 = minAmplitude(arr1, 4);
        System.out.println("min amp for array 1 is: " + amp1);

        int[] arr2 = {8,8,4,3};
        System.out.println("getting min amplitude for array 2: " +
                Arrays.toString(arr2) + " with k=2");
        int amp2 = minAmplitude(arr2, 2);
        System.out.println("min amp for array 2 is: " + amp2);
    }
}