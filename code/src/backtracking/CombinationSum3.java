package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean visited[] = new boolean[10];
        helper(1, k, n, result, temp, visited);
        return result;
    }

    public static void helper(int start, int k, int n, List<List<Integer>> result, List<Integer> temp, boolean visited[]) {
        if (temp.size() == k && n == 0) {
            List<Integer> l = new ArrayList<>(temp);
            result.add(l);
            return;
        }
        if (temp.size() == k && n != 0) {
            return;
        }
        for (int i = start; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            temp.add(i);
            helper(i + 1, k, n - i, result, temp, visited);
            visited[i] = false;
            int size = temp.size() - 1;
            temp.remove(size);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }
}
