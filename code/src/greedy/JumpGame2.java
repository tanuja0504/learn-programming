package greedy;

import java.util.Arrays;

public class JumpGame2 {

    public static int jump(int[] nums) {
        int len = nums.length;
        int jump[] = new int[len];
        Arrays.fill(jump, Integer.MAX_VALUE);
        jump[0] = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = 1; j <= nums[i] && i + j < len; j++) {
                jump[i + j] = Math.min(jump[i] + 1, jump[i + j]);

            }
        }
        return jump[len - 1];
    }

    static void printJump(int[] jump) {
        for (int i : jump) {
            System.out.print(i + " ");
        }
        System.out.println();
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
        int nums[] = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        int nums1[] = {2, 3, 1, 1, 4};
        int nums2[] = {1, 2, 3};
        int nums3[] = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        int nums4[] = {1, 1, 1, 1};
        System.out.println(jump(nums1));
    }
}
