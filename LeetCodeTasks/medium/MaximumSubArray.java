package medium;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] ints1 = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
        System.out.println(maxSubArray(ints1));
        int[] ints2 = new int[] { 1 };
        System.out.println(maxSubArray(ints2));
        int[] ints3 = new int[] { 5,4,-1,7,8 };
        System.out.println(maxSubArray(ints3));
    }

    private static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum = currentSum + nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
