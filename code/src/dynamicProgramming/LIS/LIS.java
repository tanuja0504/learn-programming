package dynamicProgramming.LIS;

//https://en.wikipedia.org/wiki/Patience_sorting
//https://leetcode.com/problems/longest-increasing-subsequence/discuss/74836/My-easy-to-understand-O(n2)-solution-using-DP-with-video-explanation
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

    public static int lengthOfLIS1(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= nums.length; i++) {
            if (nums[i - 1] > nums[i - 2]) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i - 2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length];
    }

    public static int lengthOfLIS2(int[] nums) {
        int m = nums.length;
        int dp[][] = new int[m][m];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int gap = 1; gap < m; gap++) {
            for (int i = 1, j = i + gap; j < m; i++, j++) {
                if (gap == 1) {
                    dp[i][j] = 1;
                    if (nums[i - 1] < nums[j - 1]) {
                        dp[i][j]++;
                    }
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
                    if (nums[i - 1] < nums[j - 1]) {
                        dp[i][j]++;
                    }
                }

            }
        }

        return dp[m][m];
    }

    public static int lengthOfLIS3(int[] nums) {
        int m = nums.length;
        int dp[] = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            while (j < i) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
                j++;
            }
        }
        int result = dp[0];
        for (int i = 1; i < m; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
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
        int nums2[] = {4, 10, 4, 3, 8, 9};
        int nums3[] = {0, 3, 1, 6, 2, 2, 7};
        int nums4[] = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS3(nums4));
    }
}
