package medium;

public class FirstOccurrenceInString {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    private static int strStr(String haystack, String needle) {
        int startIndex = 0;
        while (startIndex < (haystack.length() - needle.length())) {
            int i = 0;
            int j = startIndex;
            while (i < needle.length() && needle.charAt(i) == haystack.charAt(j)) {
                i++;
                j++;
            }

            if (i == needle.length()) {
                return startIndex;
            } else {
                startIndex++;
            }
        }
        return -1;
    }
}
