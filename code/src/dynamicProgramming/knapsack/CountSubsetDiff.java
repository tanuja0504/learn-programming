package dynamicProgramming.knapsack;

public class CountSubsetDiff {
    public int coundDiffSet(int nums[], int diff, int n) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((n == 1 && nums[n - 1] < diff) || sum < diff) {
            return 0;
        }
        if (n == 1 && nums[n - 1] == diff) {
            return 1;
        }
        int target = (sum + diff) / 2;
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
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
        CountSubsetDiff obj = new CountSubsetDiff();
        int nums[] = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(obj.coundDiffSet(nums, 1, nums.length));
    }
}
