package array;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        //Reducing into K Sum problem
        return kSum(nums, target, 0, 4);
    }


    //K Sum Problem
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }

    //Two Sum problem
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i])
                if (s.contains(target - nums[i]))
                    res.add(Arrays.asList(target - nums[i], nums[i]));
            s.add(nums[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 2, 2, 2};
        int target = 8;
        FourSum obj = new FourSum();
        System.out.println(obj.fourSum(nums, target));
    }
}
