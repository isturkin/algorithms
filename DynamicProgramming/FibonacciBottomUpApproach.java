import java.util.Map;
import java.util.HashMap;

public class FibonacciBottomUpApproach {

    public static long fib(int n) {
        Map<Integer, Long> cache = new HashMap<>();
        cache.put(0, 1L);
        cache.put(1, 1L);
        for (int i = 2; i <= n; i++) {
            cache.put(i, cache.get(i - 2) + cache.get(i - 1));
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 5; n++) {
            System.out.println("Fib " + n + " = " + fib(n));
        }
    }
}