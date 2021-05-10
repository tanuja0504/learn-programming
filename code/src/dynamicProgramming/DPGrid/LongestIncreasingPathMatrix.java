package dynamicProgramming.DPGrid;

import java.util.Arrays;

public class LongestIncreasingPathMatrix {
    static int result = Integer.MIN_VALUE;

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        helper(0, 0, matrix, dp);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        print(dp);
        return result;
    }

    public static int helper(int row, int col, int[][] matrix, int[][] dp) {
        if (row < 0 || col < 0 || row == matrix.length || col == matrix[0].length) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        for (int i = row; i < matrix.length; i++) {
            for (int j = col; j < matrix[0].length; j++) {
                //visited[i][j]=true;
                int a = 1, b = 1, c = 1, d = 1;
                if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
                    a += helper(i + 1, j, matrix, dp);
                }
                if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
                    b += helper(i - 1, j, matrix, dp);
                }
                if (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
                    c += helper(i, j + 1, matrix, dp);
                }
                if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
                    d += helper(i, j - 1, matrix, dp);
                }
                //visited[i][j]=false;
                dp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
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
        int matrix[][] = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int matrix1[][] = {{0}, {1}, {5}, {5}};
        System.out.println(longestIncreasingPath(matrix1));
    }
}
