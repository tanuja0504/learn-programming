package backtracking;

import java.util.Arrays;

public class ValidTriangle {
    public static int triangleNumber(int[] nums) {
        return findValid(nums, 3, 0, nums.length);
    }

    public static int findValid(int[] nums, int k, int start, int end) {
        int count = 0;
        if (start > end) {
            return count;
        } else {
            start++;
            findValid(nums, 3, start, end);
            System.out.println(Arrays.toString(nums));
            return count;
        }
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }
}
