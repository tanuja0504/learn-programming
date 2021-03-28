package misc;

import java.util.*;

public class test5 {
    public static int connectedSum(int n, List<String> edges) {
        int matrix[][] = new int[n + 1][n + 1];
        int result = 0;
        for (int i = 0; i < edges.size(); i++) {
            String s = edges.get(i);
            String input[] = s.split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            matrix[row][col] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        int size = visited.size();
        //print(matrix);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited.contains(i) && matrix[i][j] == 1) {
                    dfs(i, n, matrix, visited);
                    int t1 = (int) Math.ceil(Math.sqrt(visited.size() - size));
                    System.out.println(t1);
                    size = Math.max(size, visited.size());
                    System.out.println(visited);
                    result = t1 + result;
                }
            }
        }
        return result;
    }

    public static void dfs(int s, int n, int adj[][], Set<Integer> visited) {
        Stack<Integer> st = new Stack<>();
        st.push(s);
        visited.add(s);
        while (!st.isEmpty()) {
            int t = st.pop();
            System.out.print(t + " ");
            for (int i = 0; i <= n; i++) {
                if (adj[t][i] == 1 && !visited.contains(i)) {
                    st.push(i);
                    visited.add(i);
                }
            }
        }
    }

    public static void print(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("1 2");
        input.add("1 4");
        input.add("2 4");
        input.add("3 5");
        input.add("7 8");
        System.out.println(connectedSum(10, input));
    }
}
