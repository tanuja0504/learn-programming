package dynamicProgramming.Fibonacci;

public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int sum = 0;
        int dp[] = new int[nums.length];
        for (int i = 2; i < nums.length; i++) {
            int t1 = Math.abs(nums[i - 2] - nums[i - 1]);
            int t2 = Math.abs(nums[i - 1] - nums[i]);
            if (t1 == t2) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 7, 9};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
