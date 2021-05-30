package tree;

import java.util.TreeSet;

public class ContainsDuplicate3 {
    //This good example to implement AVL
    /* https://leetcode.com/problems/contains-duplicate-iii/discuss/824740/Simple-easy-to-understand-solution-with-video-explanation-(-TreeSet-using-sliding-window-technique)
     */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) { // O(n)
            Long el = new Long(nums[i]);
            Long floor = set.floor(el); //next lower value O(log k) in treeset

            Long ceil = set.ceiling(el); // next higher value O(log k) in treeset
            if (floor != null && Math.abs(floor - el) <= t) {
                return true;
            }
            if (ceil != null && Math.abs(ceil - el) <= t) {
                return true;
            }
            set.add(el);
            if (set.size() > k) { // size of set is always k and hence becomes a sliding window problem
                set.remove(new Long(nums[i - k]));
            }

        }
        return false;
    }
}
