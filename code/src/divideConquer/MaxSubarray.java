package divideConquer;

public class MaxSubarray {
    public static int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    public static int helper(int[] nums, int s, int e) {
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[e - 1];
        for (int i = e - 2; i >= s; i--) {
            nums[i] = nums[i] + nums[i - 1];
            max = Math.max(nums[i], max);
            System.out.println(nums[i]);
        }

        return Math.max(Math.max(helper(nums, s, e / 2),
                helper(nums, (e / 2) + 1, e)),
                helper(nums, s, e / 2) + helper(nums, (e / 2) + 1, e)
        );
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
