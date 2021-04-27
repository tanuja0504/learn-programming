package array;

import java.util.*;

public class ContainsDuplicateIII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(hmap);
            if (hmap.containsKey(nums[i]) && (i - hmap.get(nums[i])) <= k) {
                return true;
            }
            hmap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 0, 1, 1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
