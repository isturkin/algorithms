import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Parentheses {

	private static List<Character> opens = new ArrayList<>();
	private static List<Character> closers = new ArrayList<>();

	static {
		opens.add('(');
		opens.add('[');
		opens.add('{');

		closers.add(')');
		closers.add(']');
		closers.add('}');
	}

	public static boolean balanced(String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}

		Stack<Character> stack = new Stack<>();
		boolean balanced = true;
		char[] symbols = input.toCharArray();
		int i = 0;
		while (i < symbols.length && balanced) {
			char current = symbols[i];
			if (opens.contains(current)) {
				stack.push(current);
			} else {
				if (stack.isEmpty()) {
					balanced = false;
				} else {
					balanced = matches(stack.pop(), current);
				}
			}
			i++;
		}

		if (balanced && stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean matches(char open, char close) {
		return opens.indexOf(open) == closers.indexOf(close);
	}

	public static void main(String[] args) {
		String positive = "([]){}";
		System.out.printf("String %s is balanced: %b\n", positive, balanced(positive));

		String negative = "([})";
		System.out.printf("String %s is balanced: %b\n", negative, balanced(negative));
	}
}
