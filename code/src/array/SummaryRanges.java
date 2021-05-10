package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int low = 0;
        int high = 0;
        int i = 0;
        while (i < nums.length - 1) {
            StringBuilder sb = new StringBuilder();
            if (nums[i] + 1 == nums[i + 1]) {
                low = i;
                while (i < nums.length && nums[i] + 1 == nums[i + 1]) {
                    i++;
                }
                high = i;
                sb.append(nums[low]);
                sb.append("->");
                sb.append(nums[high]);
            } else {
                sb.append(nums[i]);
            }
            i++;
            result.add(sb.toString());
        }
        if (i < nums.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }
}
