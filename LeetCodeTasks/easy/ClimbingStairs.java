package easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private static Map<Integer, Integer> dpCache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {
        dpCache.put(1, 1);
        dpCache.put(2, 2);
        return climbStairs(n, 0);
    }

    private static int climbStairs(int n, int result) {
        if (n <= 2) {
            return dpCache.get(n);
        }

        for (int i = 1; i <= 2; i++) {
            int diff = n - i;
            if (dpCache.get(diff) != null) {
                result += dpCache.get(diff);
            } else {
                result += climbStairs(diff, result);
                dpCache.put(diff, result);
            }
        }

        return result;
    }
}
