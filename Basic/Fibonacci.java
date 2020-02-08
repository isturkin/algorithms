public class Main {

    public static void main(String[] args) {
        for (int n = 0; n <= 10; n++) {
            System.out.println("Fibonacci #" + n + "=" + fib(n));
        }
    }

    private static long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
