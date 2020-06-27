package searching;

import java.util.ArrayList;
import java.util.List;

public class SearchRange {
    public static Object[] searchRange(int[] nums, int target) {
        List<Integer> output = new ArrayList<>();
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + end / 2 + 1;
            if (nums[mid] == target) {
                output.add(mid);
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        System.out.println(output.size());
        return output.toArray();
    }

    public static void main(String as[]) {
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 6;
        System.out.println(searchRange(nums, target));
    }
}
