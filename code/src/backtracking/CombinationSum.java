package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0, candidates, result, temp, target);
        return result;
    }

    public static void helper(int start, int[] candidates, List<List<Integer>> result, List<Integer> temp, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            List<Integer> addList = new ArrayList<>(temp);
            result.add(addList);
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                //passing start will ensure that loop does not create same set
                helper(i, candidates, result, temp, target - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }
}
