package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        boolean visited[] = new boolean[n + 1];
        String temp = new String();
        helper(n, k, visited, list, temp);
        return String.valueOf(list.get(list.size() - 1));
    }

    public static void helper(int n, int k, boolean[] visited, List<String> list, String temp) {
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
                    temp = temp.concat(String.valueOf(i));
                    visited[i] = true;
                    helper(n, k, visited, list, temp);
                    int len = temp.length() - 1;
                    System.out.println(temp);
                    temp = temp.substring(0, len);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(getPermutation(n, k));
    }
}
