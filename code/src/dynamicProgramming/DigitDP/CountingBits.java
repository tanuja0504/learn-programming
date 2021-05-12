package dynamicProgramming.DigitDP;

public class CountingBits {
    public static int[] countBits(int num) {
        int dp[] = new int[num + 1];
        dp[0] = 0;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i / 2] + i % 2;
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 100000;
        int dp[] = countBits(n);
        for (int i : dp) {
            System.out.println(i);
        }
    }
}
