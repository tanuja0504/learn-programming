package dynamicProgramming.LCS;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean dp[][] = new boolean[m][n];
        dp[0][0] = true;
        for (int j = 2; j < n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //Case of zero star
                    boolean b1 = dp[i][j - 2];
                    char charPrevToStar = p.charAt(j - 2);
                    //Case of 1 or more times
                    boolean b2 = (dp[i - 1][j] || (charPrevToStar == '.' || charPrevToStar == s.charAt(i - 1)));
                    dp[i][j] = b1 || b2;
                }
            }
        }
        printMat(dp);
        return dp[m - 1][n - 1];
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
        String s = "si";
        String p = "s*";
        System.out.println(isMatch(s, p));
    }
}
