package dynamicProgramming;

public class Knapsack01 {
    static int x = 0;

    static void print(int x[][]) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.println(x[i][j]);
            }
        }
    }

    int knapsack(int value[], int weight[], int n, int w) {
        int val = 0;
        if (n == 0 || w == 0) {
            return val;
        }
        if (weight[n] <= w) {
            return Math.max(value[n] + knapsack(value, weight, n - 1, w - weight[n]), knapsack(value, weight, n - 1, w));
        } else {
            return knapsack(value, weight, n - 1, w);
        }
    }

    int knapsack_dp(int value[], int weight[], int n, int w) {
        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(value[i] + dp[i][w - weight[i]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        Knapsack01 o = new Knapsack01();
        System.out.println(o.knapsack_dp(val, wt, val.length - 1, W));
    }
}
