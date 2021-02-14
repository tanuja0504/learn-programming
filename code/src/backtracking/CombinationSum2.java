package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
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
                helper(start + 1, candidates, target - candidates[i], result, temp, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
                visited[start] = true;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1, 1};
        int target = 27;
        System.out.println(combinationSum2(arr, target));
    }
}
