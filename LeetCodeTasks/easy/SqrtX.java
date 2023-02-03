package easy;

public class SqrtX {

    public static void main(String[] args) {
        System.out.println("Sqrt(9)=" + mySqrt(9));
        System.out.println("Sqrt(8)=" + mySqrt(8));
        System.out.println("Sqrt(4)=" + mySqrt(4));
    }

    private static int mySqrt(int x) {
        int left = 0;
        int right = x;

        if (x < 2) {
            return x;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long multiplyResult = (long) mid * mid;
            if (multiplyResult == x) {
                return mid;
            } else if (multiplyResult > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
