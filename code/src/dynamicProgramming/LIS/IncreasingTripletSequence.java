package dynamicProgramming.LIS;

public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        int m = nums.length;
        int dp[] = new int[m];

        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < i) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
                j++;
            }
        }
        int result = dp[0];
        for (int i = 0; i < m; i++) {
            result = Math.max(result, dp[i]);
        }
        return (result >= 3) ? true : false;
    }

    public static void main(String[] args) {

    }
}
