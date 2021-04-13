package dynamicProgramming.mcm;

public class MinPalindromePartition {
    static int dp[][];

    public static int minCut(String s) {
        dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return helper(s, 0, s.length() - 1, dp);
    }

    public static int helper(String s, int low, int high, int dp[][]) {
        if (low >= high) {
            return 0;
        }
        if (isPalindrome(s, low, high)) {
            return 0;
        }
        if (dp[low][high] != -1) {
            return dp[low][high];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = low; i < high; i++) {
            if (isPalindrome(s, low, i)) {
                int temp;
                temp = helper(s, low, i, dp) + helper(s, i + 1, high, dp) + 1;
                dp[low][high] = temp;
                ans = Math.min(temp, ans);
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("chci"));
    }
}
