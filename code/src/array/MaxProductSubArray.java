package array;

public class MaxProductSubArray {
    static int maxP = Integer.MIN_VALUE;

    public static int maxProduct(int[] nums) {
        int result = nums[0];
        int max = Integer.MIN_VALUE;
        result = helper(nums, 0);
        System.out.println(result);
        return maxP;
    }

    public static int helper(int[] nums, int pos) {
        if (pos == nums.length - 1) {
            return nums[pos];
        }
        int result = 1;
        result = Math.max(nums[pos] * helper(nums, pos + 1), helper(nums, pos + 1));
        maxP = Math.max(result, maxP);
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
