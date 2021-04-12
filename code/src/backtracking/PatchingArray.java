package backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class PatchingArray {
    public static int minPatches(int[] nums, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        Set<Integer> patch = new HashSet<>();
        for (int i : nums) {
            patch.add(i);
        }
        int result = 0;
        helper(nums, 0, n, combinations, combination, visited);
        Set<Integer> sum = possibleSum(combinations, n);
        for (int i = 1; i <= n; i++) {
            if (!sum.contains(i)) {
                int choosen = i;
                result++;
                List<Integer> temp = new ArrayList<>();
                for (int k : sum) {
                    temp.add(k + choosen);
                }
                for (int k : temp) {
                    if (!sum.contains(k) && k <= n) {
                        sum.add(k);
                    }
                }
            }
        }
        return result;
    }

    public static void helper(int[] nums, int start, int n, List<List<Integer>> combinations, List<Integer> combination, boolean visited[]) {
        if (start == nums.length) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        combinations.add(new ArrayList<>(combination));
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            combination.add(nums[i]);
            visited[i] = true;
            helper(nums, i + 1, n, combinations, combination, visited);
            visited[i] = false;
            int size = combination.size() - 1;
            combination.remove(size);
        }
    }

    public static Set<Integer> possibleSum(List<List<Integer>> combinations, int n) {
        Set<Integer> sum = new HashSet<>();
        for (List<Integer> list : combinations) {
            int x = list.stream().collect(Collectors.summingInt(Integer::intValue));
            sum.add(x);
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 10};
        System.out.println(minPatches(nums, 2147483647));

    }
}