package greedy;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        boolean result = false;
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int i = 1;
        int counter = nums[0];
        while (i < nums.length) {
            if (i == nums.length - 1 && counter >= 0) {
                return true;
            } else if (counter <= 1 && nums[i] == 0) {
                return false;
            }
            counter = Math.max(nums[i], counter - 1);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        int nums1[] = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums1));
    }
}
