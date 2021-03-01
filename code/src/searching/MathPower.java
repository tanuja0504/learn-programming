package searching;

public class MathPower {
    public static double myPow(double x, int n) {
        if (n == 1)
            return x;
        if (n == 0)
            return 1;

        return x * x * myPow(x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
}
