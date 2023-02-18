package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] ints1 = new int[] { 2,7,11,15 };
        System.out.println(Arrays.toString(twoSum(ints1, 9)));
        int[] ints2 = new int[] { 3,2,4 };
        System.out.println(Arrays.toString(twoSum(ints2, 6)));
        int[] ints3 = new int[] { 3,3 };
        System.out.println(Arrays.toString(twoSum(ints3, 6)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (prevMap.get(diff) != null) {
                return new int[]{ i, prevMap.get(diff) };
            }
            prevMap.put(nums[i], i);
        }
        return new int[2];
    }
}
