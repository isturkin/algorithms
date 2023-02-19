package easy;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "11"));
    }

    private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int carry = 0;

        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int digitA = 0;
            int digitB = 0;
            if (i < a.length()) {
                digitA = Character.digit(a.charAt(i), 2);
            }
            if (i < b.length()) {
                digitB = Character.digit(b.charAt(i), 2);
            }
            int sum = digitA + digitB + carry;
            char ch = Character.forDigit(sum % 2, 2);
            sb.append(ch);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
