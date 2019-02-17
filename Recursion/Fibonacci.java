public class Fibonacci {

    public static long fib(int n) {
        if (n < 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 5; n++) {
            System.out.println("Fib " + n + " = " + fib(n));
        }
    }
}