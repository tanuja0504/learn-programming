package dynamicProgramming;

public class SubsetSum {
    public boolean subsetSum(int[] nums, int target, int n) {
        if (target == 0) {
            return true;
        }
        if (n == 0) {
            System.out.println("target " + target);
            return false;
        }
        if (nums[n - 1] <= target) {
            System.out.println(nums[n - 1] + " " + (target - nums[n - 1]));
            return subsetSum(nums, target - nums[n - 1], n - 1) || subsetSum(nums, target, n - 1);
        } else {
            return subsetSum(nums, target, n - 1);
        }
    }

    public boolean subsetSum_dp(int[] nums, int target, int n) {
        boolean dp[][] = new boolean[n + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
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
        SubsetSum obj = new SubsetSum();
        int nums[] = {1, 2, 3, 5};
        System.out.println(obj.subsetSum_dp(nums, 6, 4));
    }
}
