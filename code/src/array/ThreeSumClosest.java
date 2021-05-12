package array;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(diff)) {
                    diff = target - sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return (target - diff);
    }

    public static void main(String[] args) {
        int nums[] = {-4, -1, 1, 2};
        int target = 2;
        System.out.println(threeSumClosest(nums, target));
    }
}
