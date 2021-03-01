package searching;

public class DivTwoInts {
    public static int divide(int dividend, int divisor) {

        int tempDivisor = Math.abs(divisor);
        int tempDividend = Math.abs(dividend);
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (tempDividend < tempDivisor) {
            return 0;
        }
        int partition = 0;
        int low = 0 + tempDivisor;
        while (low <= tempDividend) {
            low = low + tempDivisor;
            partition++;
            System.out.println(partition);
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            partition = -1 * partition;
        }
        return partition;
    }

    public static int divide1(int dividend, int divisor) {
        if (Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }
        int partition = 0;
        int low = 0 + divisor;
        if (dividend < 0 || divisor < 0) {
            while (low >= dividend) {
                low = low + divisor;
                partition--;
            }
        } else {
            while (low <= dividend) {
                low = low + divisor;
                partition++;
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 1));
    }
}
