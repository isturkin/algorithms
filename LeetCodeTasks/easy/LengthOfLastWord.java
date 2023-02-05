package easy;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    private static int lengthOfLastWord(String s) {
        String trimmedString = s.trim();
        int result = 0;
        int charIndex = trimmedString.length() - 1;
        char ch;
        while (charIndex >= 0 &&
                ((ch = trimmedString.charAt(charIndex)) != ' ')) {
            result++;
            charIndex--;
        }
        return result;
    }
}
