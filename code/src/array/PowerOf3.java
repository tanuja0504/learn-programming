package array;

public class PowerOf3 {
    public static boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        } else if (n % 3 == 0)
            return isPowerOfThree(n / 3);
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(0));
    }
}
