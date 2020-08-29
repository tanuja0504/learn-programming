package recursion;

public class PowerCalculation {
    public int powerResult(int m, int n) {
        if (n == 0) {
            return m;
        }
        return powerResult(m, n - 1) * m;
    }

    public static void main(String[] args) {
        PowerCalculation obj = new PowerCalculation();

    }
}
