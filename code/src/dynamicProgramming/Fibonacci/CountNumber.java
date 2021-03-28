package dynamicProgramming.Fibonacci;

public class CountNumber {
    public static int countNumbersWithUniqueDigits(int n) {
        int CONSTANT = 10;
        if (n == 0) {
            return 0;
        }

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 10;
        int sum = dp[0] + dp[1];
        for (int j = 2; j <= n; j++) {
            int i = 0;
            int result = 1;
            while (i < j) {
                if (i == 0) {
                    result = (CONSTANT - 1) * result;
                } else {
                    result = (CONSTANT - i) * result;
                }
                i++;
            }
            sum += result;
            dp[j] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(4));
    }
}
