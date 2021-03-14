package array;

public class SqrtX {
    public static int mySqrt(int num) {
        int result = 0;
        if (num == 0 || num == 1) {
            return num;
        }
        int high = num / 2;
        int low = 1;
        long mid = high - (high - low) / 2;
        while (low <= high) {
            if (mid * mid == num) {
                return (int) mid;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
            mid = high - (high - low) / 2;
        }
        result = (int) Math.min(low, mid);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
        System.out.println(2147483647 / 2);
    }
}
