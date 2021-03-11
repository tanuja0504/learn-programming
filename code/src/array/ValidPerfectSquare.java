package array;

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int high = (num / 2) + 2;
        int low = 0;
        long mid = -1;
        boolean result = false;
        while (low <= high) {
            mid = (low + (high - low) / 2);
            if (num == (mid * mid)) {
                result = true;
                break;
            } else if (num > (mid * mid)) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(10));
    }
}
