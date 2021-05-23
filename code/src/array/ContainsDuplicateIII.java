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

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> tmap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            tmap.put(t - nums[i], i);
        }
        System.out.println(tmap);
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        //System.out.println(containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
