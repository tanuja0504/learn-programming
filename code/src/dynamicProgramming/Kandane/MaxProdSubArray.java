package dynamicProgramming.Kandane;

public class MaxProdSubArray {
    public static int maxProduct(int[] nums) {
        int k = nums.length;
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return nums[0];
        }
        /* Inspired from Kandane Algorithm
        max[i] means maximum product that can be achieved ending with i
        min[i] means minimum product that can be achieved ending with i */
        int min[] = new int[k];
        int max[] = new int[k];
        int result = nums[0];
        min[0] = max[0] = nums[0];

        for (int i = 1; i < k; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            result = Math.max(result, max[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        int nums[] = {-2, 3, 10, -4, -10};
        System.out.println(maxProduct(nums));
    }
}
