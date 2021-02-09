package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        //Initialize List for output
        List<List<Integer>> list = new ArrayList<>();
        //Take a temp list
        List<Integer> temp = new ArrayList<>();
        //Initialize visited array
        boolean visited[] = new boolean[nums.length];
        helper(nums, visited, list, temp);
        return list;
    }

    //Helper Function for DFS approach
    public static void helper(int[] nums, boolean[] visited, List<List<Integer>> list, List<Integer> temp) {
        if (temp.size() == nums.length) {
            if (!list.contains(temp)) {
                list.add(new ArrayList<>(temp));
            }
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                System.out.println("For " + i);
                printA(visited);
                visited[i] = true;
                temp.add(nums[i]);
                helper(nums, visited, list, temp);
                //This is to continue on the loop from 0 to n
                //One n times recursion is running and another this loop
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void printA(boolean[] nums) {
        for (boolean i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        System.out.println(permuteUnique(arr));
    }
}
