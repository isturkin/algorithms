import java.util.Map;
import java.util.HashMap;

public class FibonacciTopDownApproach {

    private static Map<Integer, Long> cache = new HashMap<>();

    static {
        cache.put(0, 1L);
        cache.put(1, 1L);
    }

    public static long fib(int n) {
        if (cache.get(n) != null) {
            return cache.get(n);
        } else {
            cache.put(n, fib(n - 2) + fib(n - 1));
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 5; n++) {
            System.out.println("Fib " + n + " = " + fib(n));
        }
    }
}