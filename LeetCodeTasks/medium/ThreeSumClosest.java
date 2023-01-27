package medium;

import java.util.Arrays;

// find the closest to target sum of 3 integer array elements
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums1 = new int[]{1, 1, 1, 0};
        int target = 1;
        int target1 = -100;
        System.out.println("Three sum closest: " + threeSumClosest(nums, target));
        System.out.println("Three sum closest: " + threeSumClosest(nums1, target1));
    }

    private static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            while (leftPointer < rightPointer) {
                int sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                if (sum > target) {
                    rightPointer--;
                } else {
                    leftPointer++;
                }

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }

        return result;
    }
}
