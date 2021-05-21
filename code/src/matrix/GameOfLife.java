package matrix;

import java.util.HashSet;
import java.util.Set;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int dp[][] = new int[m][n];
        Set<int[]> toFlip = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int life = getLifeCount(board, i, j) - board[i][j];
                int tuple[] = {i, j};
                if (board[i][j] == 1) {
                    if (life < 2) {
                        toFlip.add(tuple);
                    } else if (life > 3) {
                        toFlip.add(tuple);
                    }
                } else if (board[i][j] == 0) {
                    if (life == 3) {
                        toFlip.add(tuple);
                    }
                }
            }
        }
        for (int flip[] : toFlip) {
            int x = flip[0];
            int y = flip[1];
            if (board[x][y] == 0) {
                board[x][y] = 1;
            } else {
                board[x][y] = 0;
            }
        }
    }

    public static int getLifeCount(int[][] board, int row, int col) {
        int direction[][] = {
                {-1, 1}, {0, 1}, {1, 1},
                {-1, 0}, {0, 0}, {1, 0},
                {-1, -1}, {0, -1}, {1, -1}
        };
        int count = 0;
        for (int i = 0; i < direction.length; i++) {
            int x = direction[i][0] + row;
            int y = direction[i][1] + col;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                count = count + board[x][y];
            }
        }
        return count;
    }

    public static void print(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int board[][] = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        print(board);
    }
}
