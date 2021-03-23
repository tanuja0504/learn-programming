package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    static int count = 0;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int m = graph.length;
        int matrix[][] = new int[m][m];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int nums[] = graph[i];
            for (int j = 0; j < nums.length; j++) {
                matrix[i][nums[j]] = 1;
            }
        }
        boolean visited[] = new boolean[m];
        print(matrix);
        List<Integer> t = new ArrayList<>();
        t.add(0);
        helper(0, m - 1, result, t, matrix, visited);
        System.out.println(result);
        return result;
    }

    public static void helper(int s, int d, List<List<Integer>> result, List<Integer> temp, int matrix[][], boolean visited[]) {
        if (s == d) {
            count++;
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i] && matrix[s][i] == 1) {
                visited[i] = true;
                temp.add(i);
                helper(i, d, result, temp, matrix, visited);
                int t1 = temp.size() - 1;
                temp.remove(t1);
                visited[i] = false;
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
        int graph[][] = {{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }
}
