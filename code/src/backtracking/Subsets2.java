package backtracking;

import java.util.*;

public class Subsets2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //result.add(new ArrayList<>());
        List<Integer> a = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        Arrays.sort(nums);
        helper(visited, nums, 0, result, a, false);
        List<List<Integer>> list = new ArrayList<>();
        for (List e : result) {
            list.add(e);
        }
        return list;
    }


    public static void helper(boolean visited[], int[] nums, int start, List<List<Integer>> list, List<Integer> temp, boolean choosePre) {
        if (start == nums.length) {
            List a = new ArrayList(temp);
            if (!list.contains(a))
                list.add(a);
        }
        List a = new ArrayList(temp);
        if (!list.contains(a))
            list.add(new ArrayList<>(a));
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            helper(visited, nums, i + 1, list, temp, false);
            if (start >= 1 && nums[i] == nums[i - 1] && !choosePre) return;
            temp.add(nums[i]);
            helper(visited, nums, i + 1, list, temp, true);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int nums[] = {4, 4, 4, 1, 4};
        System.out.println(subsetsWithDup(nums));
    }
}
