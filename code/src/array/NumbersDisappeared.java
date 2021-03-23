package array;

import java.util.ArrayList;
import java.util.List;

public class NumbersDisappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1 && nums[0] != 1) {
            result.add(1);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (j < nums.length) {
                nums[j] = Math.abs(nums[j]) * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 7, 8, 2, 3, 1};
        int nums1[] = {2};
        System.out.println(findDisappearedNumbers(nums1));
    }
}
