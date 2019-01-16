public class Factorial {

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 5; n++) {
            System.out.println("Factorial " + n + " equals " + factorial(n));
        }
    }
}