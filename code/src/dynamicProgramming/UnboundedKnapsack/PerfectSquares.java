package dynamicProgramming.UnboundedKnapsack;

public class PerfectSquares {
    public static int numSquares(int n) {
        int range = 1;
        while (Math.pow(range, 2) <= n) {
            range++;
        }
        if (n == 1) {
            return n;
        }
        int rangeVal[] = new int[range];
        for (int i = 0; i < range; i++) {
            rangeVal[i] = i * i;
        }

        int dp[][] = new int[range][n + 1];
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                }
                if (j == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 2; i < range; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (rangeVal[i] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - i * i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printMat(dp);
        return dp[range - 1][n];
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
        System.out.println(numSquares(101));
    }
}
