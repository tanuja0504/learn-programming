package dynamicProgramming.Fibonacci;

public class IntegerBreak {
    public static int integerBreak(int n) {
        int dp[] = new int[59];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        dp[7] = 12;
        for (int i = 8; i <= n; i++) {
            dp[i] = dp[i - 4] * 3;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(9));
    }
}
