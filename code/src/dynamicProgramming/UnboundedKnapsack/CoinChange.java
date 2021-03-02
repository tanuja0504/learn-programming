package dynamicProgramming.UnboundedKnapsack;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                }
                if (i == 0) {
                    dp[i][j] = -1;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] == j) {
                    dp[i][j] = 1;
                } else if (coins[i - 1] < j) {
                    if (dp[i][j - coins[i - 1]] == -1) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (dp[i - 1][j] == -1) {
                        dp[i][j] = 1 + dp[i][j - coins[i - 1]];
                    } else {
                        dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                    }
                } else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printMat(dp);
        return dp[n][amount];
    }

    static void printMat(int x[][]) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int coins[] = {1};
        System.out.println(coinChange(coins, 3));
    }
}
