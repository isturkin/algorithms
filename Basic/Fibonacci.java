public class Fibonacci {

    public static void main(String[] args) {
        for (int n = 0; n <= 10; n++) {
            System.out.println("Fibonacci #" + n + "=" + fib(n));
        }
    }

    private static long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
	long n1 = 0;
	long n2 = 1;
	long result = 0;
	for (int i = 2; i <= n; i++) {
		result = n1 + n2;
		n1 = n2;
		n2 = result;
		
	}
        return result;
    }
}
