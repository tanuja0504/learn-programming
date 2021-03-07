package dynamicProgramming.LCS;

public class ShortestSuperSequence {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //Append String when common only once else append both characters
        printMat(dp);
        return printLCSString(str1, str2, dp);
    }

    static String printLCSString(String str1, String str2, int dp[][]) {
        //Find LCS first.
        //While Building  SCS Append String when common only once else append both characters
        int m = str1.length();
        int n = str2.length();
        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                sb.append(str1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (dp[m - 1][n] > dp[m][n - 1]) {
                    sb.append(str1.charAt(m - 1));
                    //sb.append(str2.charAt(n-1));
                    m--;
                } else {
                    //sb.append(str1.charAt(m-1));
                    sb.append(str2.charAt(n - 1));
                    n--;
                }
            }
        }
        while (m > 0) {
            sb.append(str1.charAt(m - 1));
            m--;
        }
        while (n > 0) {
            sb.append(str2.charAt(n - 1));
            n--;
        }
        return sb.reverse().toString();
    }

    static void printMat(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "--");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("intention", "execution"));
    }
}
