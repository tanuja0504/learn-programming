package dynamicProgramming.LCS;

import java.util.Arrays;

public class WiggleSubsequence {
    //Used Palindrome Approach
    //But can do in O(n) https://leetcode.com/problems/wiggle-subsequence/discuss/84849/Very-Simple-Java-Solution-with-detail-explanation
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        int max = 0;
        boolean isPeak[] = new boolean[n];
        Arrays.fill(isPeak, false);
        isPeak[0] = true;

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = i + gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    isPeak[i + 1] = (nums[j] - nums[i] > 0) ? true : false;
                    dp[i][j] = 1;
                    if (nums[j] != nums[i]) {
                        dp[i][j] = dp[i][j] + 1;
                    }
                } else {
                    int t = nums[j] - nums[j - 1];
                    if (t > 0 && !isPeak[i + 1]) {
                        dp[i][j] = dp[i][j - 1] + 1;
                        isPeak[i + 1] = !isPeak[i + 1];
                    } else if (t < 0 && isPeak[i]) {
                        dp[i][j] = dp[i][j - 1] + 1;
                        isPeak[i + 1] = !isPeak[i + 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }

        printMat(dp);

        return max;
    }

    public static int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        int relationship[] = new int[n];
        int dp[] = new int[n];
        relationship[0] = 0;
        for (int i = 1; i < n; i++) {
            relationship[i] = Integer.compare(nums[i], nums[i - 1]);
        }
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (relationship[i] == 0) {
                dp[i] = 1;
            } else if (relationship[i] != relationship[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[n - 1];
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
        int nums[] = {1, 7, 4, 9, 2, 5};
        int nums1[] = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int nums2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int nums3[] = {1, 1, 7, 4};
        System.out.println(wiggleMaxLength1(nums3));
    }
}
