package string;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {

        StringBuilder result = new StringBuilder();
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        boolean isNegative = false;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            isNegative = true;
        }

        result.append(n / d);
        if (n % d != 0) {
            result.append('.');
            long remainder = n % d;
            Map<Long, Integer> hmap = new HashMap<>();
            while (remainder != 0) {
                if (!hmap.containsKey(remainder)) {
                    hmap.put(remainder, result.length());
                    remainder = remainder * 10;
                    long t = remainder / d;
                    remainder = remainder % d;
                    result.append(t);
                } else {
                    int index = hmap.get(remainder);
                    result.insert(index, '(');
                    result.append(')');
                    break;
                }
            }
        }

        if (isNegative) {
            result.insert(0, '-');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, -2147483648));
    }
}
