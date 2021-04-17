package dynamicProgramming.LCS;

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        //https://www.youtube.com/watch?v=XmSOWnL6T_I
        int m = s.length();
        boolean dp[][] = new boolean[m][m];
        int count = 0;

        for (int gap = 0; gap < m; gap++) {
            for (int i = 0, j = i + gap; j < m; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }
        printMat(dp);
        return count;
    }

    public static void printMat(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
