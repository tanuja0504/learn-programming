package dynamicProgramming;

public class CountSubsetSum {
    static int result = 0;

    public int subsetSum(int[] nums, int target, int n) {
        if (n == 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (nums[n - 1] <= target) {
            //System.out.println(target);
            return subsetSum(nums, target, n - 1) + subsetSum(nums, target - nums[n - 1], n - 1);
        } else {
            return subsetSum(nums, target, n - 1);
        }
    }

    public int subsetSum_dp(int[] nums, int target, int n) {
        int dp[][] = new int[n + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        CountSubsetSum obj = new CountSubsetSum();
        int nums[] = {2, 3, 5, 8, 10};
        System.out.println(obj.subsetSum_dp(nums, 10, 5));
    }
}
