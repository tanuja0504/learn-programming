package dynamicProgramming.knapsack;

public class EqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }


        boolean dp[][] = new boolean[sum / 2 + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= sum / 2; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= nums[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - nums[j - 1]][j - 1];
                }
            }
        }

        for (int i = 0; i <= sum / 2; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[sum / 2][n];
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 11, 5};
        System.out.println("Result " + canPartition(nums));
    }
}
