package medium;

import java.util.Arrays;

public class TwoSum2WithSortedInputArray {

    public static void main(String[] args) {
        int[] numbers1 = new int[]{2, 7, 11, 15};
        int[] numbers2 = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(twoSum(numbers1, 9)));
        System.out.println(Arrays.toString(twoSum(numbers2, 6)));

    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int leftPointer = 0;
        int rightPointer = numbers.length - 1;
        while (leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if (sum > target) {
                rightPointer--;
            } else if (sum < target) {
                leftPointer++;
            } else {
                result[0] = ++leftPointer;
                result[1] = ++rightPointer;
                break;
            }
        }

        return result;
    }
}
