package dynamicProgramming;

public class MinSubsetSumDiff {

    public int minDiff(int nums[], int n) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
        }
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        /*for(int i=0;i<n;i++){
            for(int j=0;j<sum;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        for (int i = 0; i < sum + 1 / 2; i++) {
            if (dp[n][i]) {
                int range = sum - 2 * i;
                range = Math.abs(range);
                minSum = Math.min(range, minSum);
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        MinSubsetSumDiff obj = new MinSubsetSumDiff();
        int nums[] = {1, 5, 6, 11};
        System.out.println(obj.minDiff(nums, nums.length));
    }
}
