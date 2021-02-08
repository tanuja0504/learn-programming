package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, list);
        return list;
    }

    public static void helper(int[] nums, int fixIndex, List<List<Integer>> list) {
        if (fixIndex == nums.length) {
            return;
        }
        List<Integer> a = new ArrayList<>();
        a.add(nums[fixIndex]);
        for (int i = 0; i < nums.length; i++) {
            if (fixIndex == i) {
                continue;
            }
            a.add(nums[i]);
        }
        list.add(a);

        helper(nums, ++fixIndex, list);

    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    a.add(nums[j]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(permute(arr));
    }
}
