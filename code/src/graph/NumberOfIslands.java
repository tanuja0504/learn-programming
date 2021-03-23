package graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    numIslands++;
                    dfsHelper(i, j, grid, visited);
                }
            }
        }
        return numIslands;
    }

    public static void dfsHelper(int i, int j, char[][] grid, boolean visited[][]) {
        Stack<List<Integer>> st = new Stack<>();
        List<Integer> pos = new ArrayList<>();
        pos.add(i);
        pos.add(j);
        st.push(pos);
        while (!st.isEmpty()) {
            List<Integer> temp = st.pop();
            int row = temp.get(0);
            int col = temp.get(1);
            visited[row][col] = true;
            if (row < grid.length - 1 && !visited[row + 1][col] && grid[row + 1][col] == '1') {
                visited[row + 1][col] = true;
                List<Integer> cube = new ArrayList<>();
                cube.add(row + 1);
                cube.add(col);
                st.push(cube);
            }
            if (row > 0 && !visited[row - 1][col] && grid[row - 1][col] == '1') {
                visited[row - 1][col] = true;
                List<Integer> cube = new ArrayList<>();
                cube.add(row - 1);
                cube.add(col);
                st.push(cube);
            }
            if (col < grid[0].length - 1 && !visited[row][col + 1] && grid[row][col + 1] == '1') {
                visited[row][col + 1] = true;
                List<Integer> cube = new ArrayList<>();
                cube.add(row);
                cube.add(col + 1);
                st.push(cube);
            }
            if (col > 0 && !visited[row][col - 1] && grid[row][col - 1] == '1') {
                visited[row][col - 1] = true;
                List<Integer> cube = new ArrayList<>();
                cube.add(row);
                cube.add(col - 1);
                st.push(cube);
            }

        }
    }

    public static void main(String[] args) {
        char grid[][] = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        char grid1[][] = {{1}};
        char grid2[][] = {{'1', '1', '1'}, {'1', '0', '1'}, {'1', '1', '1'}};
        System.out.println(numIslands(grid2));
    }
}