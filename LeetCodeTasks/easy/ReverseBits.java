package easy;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(2147483647));
        System.out.println(reverse(-1638477412));
    }

    // 123 % 10 = 3 - explanation how exactly extracting of the last digit works
    // you need treat n as an unsigned value
    private static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10; // equals to 3 after the first iteration, it's used to consequently get each digit
            x = x / 10; // equals to 123 / 10 = 12 after the first iteration
            if (reversed > Integer.MAX_VALUE / 10) return 0;
            if (reversed < Integer.MIN_VALUE / 10) return 0;
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }

}
