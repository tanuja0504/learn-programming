package BitManipulation;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber3 {
    public static int[] singleNumber(int[] nums) {
        int result[] = {0, 0};
        Set<Integer> hset = new HashSet<>();
        for (int i : nums) {
            if (hset.contains(i)) {
                hset.remove(i);
            } else {
                hset.add(i);
            }
        }
        int t = 0;
        for (int i : hset) {
            result[t] = i;
            t++;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {3, 1, 2, 2};
        int result[] = singleNumber(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
