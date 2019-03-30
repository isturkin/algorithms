public class ReversedString {

    public static void main(String[] args) {
        String original = "telephone";
        String reversed = reverse(original);

        System.out.println("Reversed string: " + reversed);
    }

    private static String reverse(String original) {
        int n = original.length();
        char[] reversed = original.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char temp = reversed[n - 1 - i];;
            reversed[n - 1 - i] = reversed[i];
            reversed[i] = temp;
        }
        return new String(reversed);
    }
}