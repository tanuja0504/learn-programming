package dynamicProgramming.LCS;

public class InterleavingString {

    public static boolean longestCommonSubsequenceDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //Going diagonally due to choice diagram
                    //If same we add 1 and max so far
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        String temp = printString(s1, s2, dp);
        return (s1.equals(temp)) ? true : false;
    }

    public static String printString(String s1, String s2, int dp[][]) {
        StringBuilder sb = new StringBuilder();
        int m = s1.length();
        int n = s2.length();
        while (m > 0 && n > 0) {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                sb.append(s1.charAt(m - 1));
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

    public static boolean isInterleave(String s1, String s2, String s3) {
        return longestCommonSubsequenceDP(s1, s3) && longestCommonSubsequenceDP(s2, s3) && (s1.length() + s2.length() == s3.length());
    }

    public static boolean isSubsequence1(String s1, String s2, String s3) {
        int m = s1.length() - 1;
        int n = s2.length() - 1;
        int p = s3.length() - 1;
        while ((m >= 0 || n >= 0) && p >= 0) {
            System.out.println(s3.charAt(p));
            if (m >= 0 && s1.charAt(m) == s3.charAt(p)) {
                m--;
                p--;
                System.out.println("Moving m");
            } else if (n >= 0 && s2.charAt(n) == s3.charAt(p)) {
                n--;
                p--;
                System.out.println("Moving n");
            } else {
                return false;
            }
        }
        System.out.println(m + " " + n);
        return (m == -1 && n == -1 && p == -1) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence1("aabc", "abad", "aabadabc"));
    }
}
