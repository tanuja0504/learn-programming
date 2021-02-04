package array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ThirdMax {
    public static int thirdMax(int[] nums) {

        Arrays.sort(nums);
        int i = nums.length - 1;
        int count = 0;
        Map<Integer, Integer> tmap = new TreeMap<>();
        while (i >= 0 && tmap.size() < 3) {
            tmap.put(nums[i], 0);
            i--;
        }
        System.out.println(tmap);
        if (tmap.size() < 3) {
            return ((TreeMap<Integer, Integer>) tmap).lastKey();
        }
        return ((TreeMap<Integer, Integer>) tmap).firstKey();
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 5, 3, 5};
        System.out.println(thirdMax(arr));
    }
}
