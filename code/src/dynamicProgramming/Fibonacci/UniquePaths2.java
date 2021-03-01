package dynamicProgramming.Fibonacci;

public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1 && dp[i - 1][0] != 0) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] != 1 && dp[0][i - 1] != 0) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        print(dp);
        return dp[m - 1][n - 1];
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int obstacleGrid[][] = {{0, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int obstacleGrid1[][] = {{0, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));
    }
}
