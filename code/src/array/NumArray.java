package array;

public class NumArray {
    int sums[];
    int end = -1;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return (i == 0) ? sums[j] : (sums[j] - sums[i - 1]);
    }
}
