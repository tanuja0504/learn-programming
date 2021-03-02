package dynamicProgramming.Fibonacci;

public class HouseRobber {
    public static int rob(int[] nums) {
        int k = nums.length;
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return nums[0];
        }
        int dp[] = new int[k + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= k; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[k];
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(rob(nums));
    }
}
