package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int candidate1 = Integer.MAX_VALUE;
        int i = 0;
        while (i < nums.length) {
            if (count1 == 0) {
                candidate1 = nums[i];
            } else if (nums[i] == candidate1) {
                count1++;
            } else {
                count1--;
            }
            i++;
        }
        int count2 = 0;
        int candidate2 = Integer.MAX_VALUE;
        i = 0;

        while (i < nums.length) {
            if (nums[i] == candidate1) {
                i++;
                continue;
            } else if (count2 == 0) {
                candidate2 = nums[i];
            } else if (nums[i] == candidate2) {
                count2++;
            } else {
                count2--;
            }
            i++;
        }
        count1 = 0;
        count2 = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == candidate1) {
                count1++;
            }
            if (nums[j] == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 1, 1};
        System.out.println(majorityElement(nums));
    }
}
