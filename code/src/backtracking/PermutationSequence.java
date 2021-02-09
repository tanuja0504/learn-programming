package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        boolean visited[] = new boolean[n + 1];
        StringBuilder temp = new StringBuilder();
        helper(n, k, visited, list, temp);
        System.out.println(list);
        return String.valueOf(list.get(list.size() - 1));
    }

    public static void helper(int n, int k, boolean[] visited, List<String> list, StringBuilder temp) {
        if (list.size() == k) {
            return;
        }
        if (temp.length() == n) {
            list.add(new String(temp));
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                } else {
                    temp = temp.append(i);
                    visited[i] = true;
                    helper(n, k, visited, list, temp);
                    int len = temp.length() - 1;
                    temp.deleteCharAt(len);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println(getPermutation(n, k));
    }
}
