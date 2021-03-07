package dynamicProgramming.LCS;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int m = t.length();
        int n = s.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return (dp[m][n] == s.length()) ? true : false;
    }

    public static boolean isSubsequence1(String s, String t) {
        int m = s.length() - 1;
        int n = t.length() - 1;
        while (m > 0 && n > 0) {
            if (s.charAt(m) == t.charAt(n)) {
                m--;
                n--;
            } else {
                n--;
            }
        }
        return (m == 0) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence1("abc", "abdefc"));
    }
}
