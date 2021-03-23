package greedy;

public class JumpGame2 {

    public static int jump(int[] nums) {
        int r = Integer.MAX_VALUE;
        if (nums.length == 1) {
            return 0;
        }
        int jump[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            printJump(jump);
            while (j > 0 && j < nums.length && jump[j] < nums.length) {
                //System.out.println(jump[i]);
                if (nums[j] == 0) {
                    jump[i] = Integer.MIN_VALUE;
                    break;
                }
                j = nums[j];
                jump[i] = jump[i] + 1;
            }
        }
        for (int i : jump) {

            r = Math.min(r + i, i);
        }
        return r;
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
        System.out.println(jump(nums3));
    }
}
