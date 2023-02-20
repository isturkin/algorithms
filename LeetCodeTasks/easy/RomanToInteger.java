package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = romanToIntegerMap.get(s.charAt(i));
            if (i + 1 < s.length() && a < romanToIntegerMap.get(s.charAt(i + 1))) {
                sum -= romanToIntegerMap.get(s.charAt(i));
            } else {
                sum += romanToIntegerMap.get(s.charAt(i));
            }
        }

        return sum;
    }
}
