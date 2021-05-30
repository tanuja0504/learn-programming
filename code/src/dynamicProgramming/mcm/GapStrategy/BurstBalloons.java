package dynamicProgramming.mcm.GapStrategy;

public class BurstBalloons {
    /*https://www.youtube.com/watch?v=YzvF8CqPafI&t=2602s
     */
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = (k == i) ? 0 : dp[i][k - 1]; // At the start
                    int right = (k == j) ? 0 : dp[k + 1][j]; // At the last
                    // Because at the extreme ends value should be assumed is 1
                    int val = ((i == 0) ? 1 : nums[i - 1]) * (nums[k]) * ((j == n - 1) ? 1 : nums[j + 1]);
                    System.out.println(left + " " + val + " " + right);
                    int coins = left + val + right;
                    max = Math.max(coins, max); // Max so far
                }
                dp[i][j] = max;
            }
        }
        printMat(dp);
        return dp[0][n - 1];
    }

    public static void printMat(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + "    ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nums[] = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }
}
