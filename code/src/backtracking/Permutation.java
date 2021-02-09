package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        helper(nums, visited, list, temp);
        return list;
    }

    public static void helper(int[] nums, boolean[] visited, List<List<Integer>> list, List<Integer> temp) {
        if (temp.size() == nums.length) {
            System.out.println("Adding " + temp);
            list.add(new ArrayList<>(temp));
            return;
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (visited[j]) {
                    continue;
                }
                visited[j] = true;
                temp.add(nums[j]);
                helper(nums, visited, list, temp);
                System.out.println("Primary Loop Value" + j);
                temp.remove(temp.size() - 1);
                visited[j] = false;
            }
        }


    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(permute(arr));
    }
}
