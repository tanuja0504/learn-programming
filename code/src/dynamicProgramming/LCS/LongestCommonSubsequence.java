package dynamicProgramming.LCS;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() <= 0 || text2.length() <= 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return 1 + longestCommonSubsequence(text1.substring(0, m - 1), text2.substring(0, n - 1));
        } else {
            return Math.max(longestCommonSubsequence(text1, text2.substring(0, n - 1))
                    , longestCommonSubsequence(text1.substring(0, m - 1), text2));
        }
    }

    public static int longestCommonSubsequenceDP(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //Going diagonally due to choice diagram
                    //If same we add 1 and max so far
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        printMat(dp);
        System.out.println(printString(text1, text2, dp));
        return dp[m][n];
    }

    static String printString(String text1, String text2, int dp[][]) {
        StringBuilder sb = new StringBuilder();
        int m = text1.length();
        int n = text2.length();

        while (m > 0 && n > 0) {

            if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
                sb.append(text1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (dp[m - 1][n] > dp[m][n - 1]) {
                    m--;
                } else {
                    n--;
                }
            }

        }
        return sb.reverse().toString();
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
        System.out.println(longestCommonSubsequenceDP("abc", "adc"));
    }
}
