package array;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        while (start < end) {
            if (nums[end] > nums[end - 1]) {
                break;
            }
            end--;
        }
        if (end == start) {
            Arrays.sort(nums);
        } else {
            int temp = nums[end];
            start = end + 1;
            while (start < nums.length) {
                if (nums[start] < nums[end]) {
                    break;
                }
                start++;
            }
            if (start == nums.length) {

            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
