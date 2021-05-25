package dynamicProgramming.LCS;

public class InterleavingString {

    //https://www.youtube.com/watch?v=ih2OZ9-M3OM
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }

        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int t = i + j - 1;
                if (j == 0 && s3.charAt(t) == s1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j];
                }
                if (i == 0 && s3.charAt(t) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] || dp[i][j];
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int t = i + j - 1;
                if (s3.charAt(t) == s1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j];
                }
                if (s3.charAt(t) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] || dp[i][j];
                }

            }

        }
        printMat(dp);
        return dp[m][n];
    }

    static void printMat(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println(isInterleave("aabc", "abad", "aabadabc"));
    }
}
