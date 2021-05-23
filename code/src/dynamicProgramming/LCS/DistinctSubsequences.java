package dynamicProgramming.LCS;

public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int m = t.length() + 1;
        int n = s.length() + 1;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        printMat(dp);
        return dp[m - 1][n - 1];
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
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }
}
