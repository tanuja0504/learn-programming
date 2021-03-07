package dynamicProgramming.LCS;

public class MinInsertionPalindrome {
    public static int minInsertions(String s) {
        int m = s.length();
        StringBuilder t1 = new StringBuilder(s);
        String t = t1.reverse().toString();
        int dp[][] = new int[m + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        printMat(dp);
        return m - dp[m][m];
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
        System.out.println(minInsertions("zzazz"));
    }
}
