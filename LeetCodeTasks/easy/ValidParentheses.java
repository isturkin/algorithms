package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private static final char LEFT_OPEN_PARENTHESIS = '(';
    private static final char RIGHT_CLOSED_PARENTHESIS = ')';
    private static final char LEFT_OPEN_SQUARE_BRACKET = '[';
    private static final char RIGHT_CLOSED_SQUARE_BRACKET = ']';
    private static final char LEFT_OPEN_CURLY_BRACKET = '{';
    private static final char RIGHT_CLOSED_CURLY_BRACKET = '}';

    private static final Map<Character, Character> BRACKETS_MAP = new HashMap<>(3);

    static {
        BRACKETS_MAP.put(LEFT_OPEN_PARENTHESIS, RIGHT_CLOSED_PARENTHESIS);
        BRACKETS_MAP.put(LEFT_OPEN_SQUARE_BRACKET, RIGHT_CLOSED_SQUARE_BRACKET);
        BRACKETS_MAP.put(LEFT_OPEN_CURLY_BRACKET, RIGHT_CLOSED_CURLY_BRACKET);
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[()]}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("["));
        System.out.println(isValid("(("));
        System.out.println(isValid("){"));
        System.out.println(isValid(")(){}"));
    }

    private static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (BRACKETS_MAP.containsKey(currentChar)) {
                stack.push(s.charAt(i));
            } else if (!stack.empty()){
                char ch = stack.pop();
                if (BRACKETS_MAP.get(ch) != currentChar) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
