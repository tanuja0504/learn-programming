package dynamicProgramming.Fibonacci;

public class MaxProdSubArray {
    public static int maxProduct(int[] nums) {
        int k = nums.length;
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return nums[0];
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < k; i++) {
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int nums[] = {-2, 3, 10, -4, -10};
        System.out.println(maxProduct(nums));
    }
}
