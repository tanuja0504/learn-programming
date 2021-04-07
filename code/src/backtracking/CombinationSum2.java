package backtracking;

import java.util.*;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        //boolean visited[] = new boolean[candidates.length];
        boolean visited[] = new boolean[candidates.length];
        helper(0, candidates, target, result, temp, visited);
        return result;
    }

    public static void helper(int start, int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, boolean[] visited) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            List<Integer> t = new ArrayList<>(temp);
            t.sort(Comparator.naturalOrder());
            if (!result.contains(t))
                result.add(t);
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (target - candidates[i] < 0) break;
                if (visited[i]) {
                    continue;
                }
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                temp.add(candidates[i]);
                visited[i] = true;
                helper(i + 1, candidates, target - candidates[i], result, temp, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void helper1(int start, int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, boolean[] visited) {
        if (target < 0) {
            System.out.println(target);
            return;
        } else if (target == 0) {
            List<Integer> t = new ArrayList<>(temp);
            //Collections.sort(t);
            if (!result.contains(t))
                result.add(t);
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (visited[i]) {
                    continue;
                }
                System.out.println(temp);
                temp.add(candidates[i]);
                visited[i] = true;
                System.out.println(start + 1);
                helper1(start + 1, candidates, target - candidates[i], result, temp, visited);
                int size = temp.size() - 1;
                temp.remove(size);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 3, 3, 5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));
    }
}
