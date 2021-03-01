package searching;

public class SquareRoot {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1;
        int end = x;
        int mid = start + ((end - start) / 2);
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                end = mid - 1;
            } else if (mid * mid < x) {
                start = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
