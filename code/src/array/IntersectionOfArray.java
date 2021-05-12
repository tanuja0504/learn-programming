package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArray {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hmap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i : nums1) {
            int count = 1;
            if (hmap.containsKey(i)) {
                count = count + hmap.get(i);
            }
            hmap.put(i, count);
        }
        System.out.println(hmap);
        for (int i : nums2) {
            if (hmap.containsKey(i) && hmap.get(i) > 0) {
                int count = hmap.get(i);
                count = hmap.get(i) - 1;
                hmap.put(i, count);
                result.add(i);
            }
        }
        System.out.println(hmap);
        int intersection[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        return intersection;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        int nums3[] = intersect(nums1, nums2);
        for (int i : nums3) {
            System.out.println(i);
        }
    }

}
