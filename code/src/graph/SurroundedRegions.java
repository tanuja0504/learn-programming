package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Set<List<Integer>> result = isAdjacent(board);
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    List<Integer> verticalDown = new ArrayList<>();
                    verticalDown.add(i + 1);
                    verticalDown.add(j);
                    List<Integer> horizontalDown = new ArrayList<>();
                    horizontalDown.add(i);
                    horizontalDown.add(j + 1);
                    boolean surroundedDown = result.contains(verticalDown) && result.contains(horizontalDown);
                    List<Integer> verticalUp = new ArrayList<>();
                    verticalUp.add(i - 1);
                    verticalUp.add(j);
                    List<Integer> horizontalUp = new ArrayList<>();
                    horizontalUp.add(i);
                    horizontalUp.add(j - 1);
                    boolean surroundedUp = result.contains(verticalUp) && result.contains(horizontalUp);
                    if (surroundedDown && surroundedUp) {
                        List<Integer> tuple = new ArrayList<>();
                        result.add(tuple);
                    }
                }
            }
        }
    }

    public static Set<List<Integer>> isAdjacent(char[][] board) {
        Set<List<Integer>> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        List<Integer> arr = new ArrayList<>();
                        arr.add(i);
                        arr.add(j);
                        result.add(arr);
                    }
                }
            }
        }
        return result;
    }

    public static void print(char[][] board) {

    }

    public static void main(String[] args) {
        char board[][] = {{'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'}};
        solve(board);

    }
}
