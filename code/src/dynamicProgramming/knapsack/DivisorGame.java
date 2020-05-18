package dynamicProgramming.knapsack;

public class DivisorGame {
    public static boolean divisorGame(int N) {
        boolean a[] = new boolean[N + 1];
        a[0] = false;
        a[1] = false;
        a[2] = true;
        int i = 3;
        while (i < N) {
            if (N % i == 0) {
                N = N - i;
                a[i] = true;
            } else
                a[i] = false;
        }
        return a[N];
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(3));
    }
}
