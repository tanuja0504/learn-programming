package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean visited[] = new boolean[n + 1];
        helper(result, new ArrayList<>(), 1, n, visited, k);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> temp, int start, int n, boolean visited[], int k) {
        if (start > n) {
            return;
        } else if (k == temp.size()) {
            result.add(new ArrayList<>(temp));
            visited[start] = true;
            return;
        } else {
            for (int i = start; i <= n; i++) {
                System.out.println("Pro-->" + start);
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                temp.add(i);
                helper(result, temp, i + 1, n, visited, k);
                visited[i] = false;
                temp.remove(temp.size() - 1);
                //start=start+1;
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
        int n = 3, k = 3;
        System.out.println(combine(n, k));
    }
}
