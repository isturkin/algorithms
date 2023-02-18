package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {

    public static void main(String[] args) {
        int[] ints1 = new int[]{ 2, 3, 6, 7 };
        System.out.println(combinationSum(ints1, 7));
        int[] ints2 = new int[] { 2,3,5 };
        System.out.println(combinationSum(ints2, 8));
        int[] ints3 = new int[] { 2 };
        System.out.println(combinationSum(ints3, 1));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, result, new Stack<>(), 0, 0, target);
        return result;
    }

    private static void dfs(int[] candidates, List<List<Integer>> result, Stack<Integer> combination,
                            int i, int sum, int target) {
        if (sum == target) {
            result.add(List.copyOf(combination));
            return;
        }

        if (i >= candidates.length || sum > target) {
            return;
        }

        combination.push(candidates[i]);
        dfs(candidates, result, combination, i, sum + candidates[i], target);
        combination.pop();
        dfs(candidates, result, combination, i + 1, sum, target);
    }
}
