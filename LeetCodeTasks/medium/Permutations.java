package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3 }));
    }

    private static List<List<Integer>> permute(int[] nums) {
        System.out.println("Try to find permutation for " + Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            List<List<Integer>> singleIntPermutation = new ArrayList<>();
            singleIntPermutation.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
            return singleIntPermutation;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] n = copyArrayWithoutElementByIndex(nums, i);
            List<List<Integer>> perms = permute(n);

            for (List<Integer> perm: perms) {
                perm.add(nums[i]);
            }
            result.addAll(perms);
        }

        return result;
    }

    private static int[] copyArrayWithoutElementByIndex(int[] nums, int index) {
        int[] result = new int[nums.length - 1];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i != index) {
                result[j] = nums[i];
                j++;
            }
        }
        return result;
    }
}
