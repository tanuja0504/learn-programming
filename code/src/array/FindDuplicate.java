package array;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        Set<Integer> hset = new HashSet<>();
        for (int i : nums) {
            if (hset.contains(i)) {
                return i;
            } else {
                hset.add(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));
    }
}
