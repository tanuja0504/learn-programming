package dynamicProgramming.DPGrid;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int ansMax = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0) && matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    ansMax = 1;
                }
            }
        }
        //print(dp);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int t = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    if (t > 0) {
                        dp[i][j] = t + 1;
                        ansMax = Math.max(ansMax, dp[i][j]);
                    } else if (t == 0) {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        print(dp);
        return ansMax * ansMax;
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char matrix[][] = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char matrix1[][] = {{'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'0', '0', '1', '1', '1'}};

        System.out.println(maximalSquare(matrix));
    }
}
