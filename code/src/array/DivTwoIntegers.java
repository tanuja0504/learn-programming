package array;

public class DivTwoIntegers {
    public static int divide(int dividend, int divisor) {
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = -1;
        }
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        int count = 0;
        while (a >= b) {
            count++;
            a = a - b;
        }
        return count * flag;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
