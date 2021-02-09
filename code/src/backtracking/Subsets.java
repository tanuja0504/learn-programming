package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        helper(nums, 0, list, a);
        Set<List<Integer>> hset = new HashSet<>();
        for (List<Integer> b : list) {
            hset.add(b);
        }
        list.clear();
        for (List<Integer> c : hset) {
            list.add(c);
        }
        return list;
    }

    public static void helper(int[] nums, int start, List<List<Integer>> list, List<Integer> temp) {
        if (start == nums.length) {
            list.add(temp);
        }
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1, list, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int j = 0;
        list.add(temp);

        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            while (j < nums.length) {
                if (j != i) {
                    temp.add(nums[j]);
                    list.add(temp);
                }
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(subsets1(arr));
    }
}
