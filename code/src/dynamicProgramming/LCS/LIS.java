package dynamicProgramming.LCS;

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int m = nums.length;
        int dp[][] = new int[m + 1][m + 1];
        printMat(dp);
        System.out.println();
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                if (i < j && nums[i - 1] < nums[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        printMat(dp);
        return dp[m][m];
    }

    static void printMat(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int nums1[] = {-2, -1};
        System.out.println(lengthOfLIS(nums1));
    }
}
