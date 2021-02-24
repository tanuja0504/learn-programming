package dynamicProgramming.Fibonacci;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n > 2) {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
