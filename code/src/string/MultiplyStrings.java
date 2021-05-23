package string;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (m >= 0 && n >= 0) {
            int a = num1.charAt(m) - '0';
            int b = num2.charAt(n) - '0';
            int c = (a * b) + carry;
            carry = c / 10;
            c = c % 10;
            if (result.length() == 0) {
                result.append(c);
            } else {
                result.insert(c, 0);
            }
            m--;
            n--;
        }
        result.append(carry);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("16", "4"));
    }
}
