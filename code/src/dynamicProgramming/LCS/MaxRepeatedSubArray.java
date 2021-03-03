package dynamicProgramming.LCS;

public class MaxRepeatedSubArray {
    public static int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int max = 0;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    //Going diagonally due to choice diagram
                    //If same we add 1 and max so far
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        printMat(dp);
        return max;
    }

    static void printMat(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 2, 1};
        int B[] = {3, 2, 1, 4, 7};
        System.out.println(findLength(A, B));
    }
}
