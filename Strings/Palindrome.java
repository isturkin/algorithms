public class Palindrome {

    public static void main(String[] args) {
        String[] examples = new String[] {"level", "cat", "refer"};

        for (String string : examples) {
            if (isPalindrome(string)) {
                System.out.println(string + " is a palindrome");
            } else {
                System.out.println(string + " is not a palindrome");
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}