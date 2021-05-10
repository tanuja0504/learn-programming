package array;

public class Atoi {
    static int bound = 48;

    public static int myAtoi(String str) {
        int result = 0;
        int i = 0;
        boolean isNegative = false;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            isNegative = (str.charAt(i) == '-');
            i++;
        }
        System.out.println(i + " " + isNegative);
        while (i < str.length() && result < Integer.MAX_VALUE) {

            char t = str.charAt(i);
            boolean temp = isInt(t);
            int val = t - bound;
            if (temp) {
                if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && val > 7)) {
                    if (isNegative) {
                        result = Integer.MIN_VALUE;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                    return result;
                }

                result = result * 10;
                result = result + val;

            } else {
                break;
            }
            i++;
        }

        if (isNegative) {
            result = result * -1;
        }
        return result;
    }

    public static boolean isInt(char c) {
        int t = c - bound;
        return (t >= 0 && t <= 9);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  -0012a42"));
    }
}
