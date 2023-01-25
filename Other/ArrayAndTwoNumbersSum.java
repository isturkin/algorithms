public class ArrayAndTwoNumbersSum {

    public static void main(String[] args) {
        int[] a = new int[] { 2, 4, 5, 1, 8 };
        int target = 5;

        System.out.println(findTwoNumbersForTargetSum(a, target));
    }

    // it's the simplest solution of the problem
    private static Pair findTwoNumbersForTargetSum(int[] a, int target) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (target == a[i] + a[j]) {
                    return new Pair(a[i], a[j]);
                }
            }
        }
        return null;
    }

    private static class Pair {

        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "[" + first + ", " + second + "]";
        }
    }
}
