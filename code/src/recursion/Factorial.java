package recursion;

public class Factorial {
    public int factorial(int n) {
        if (n <= 0) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public int factorialLoop(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        Factorial obj = new Factorial();
        System.out.println(obj.factorialLoop(7));
    }
}
