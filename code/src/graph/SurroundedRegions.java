package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /* Use BFS.This problem is similar to Number of Islands.
    In this problem, only the cells on the boarders can not be surrounded.
    So we can first merge those O's on the boarders like in Number of Islands
    and replace O's with 'B', and then scan the board and replace all O's left */

    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        //helpful for conditions like {x-1,y} {x+1,y} {x,y+1} {x,y-1}
        int direction[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == row - 1 || j == col - 1)) {
                    q.add(new Point(i, j));
                    board[i][j] = 'N'; //Mark with different letter so that represents not allowed
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        for (int k = 0; k < direction.length; k++) {
                            int x1 = direction[k][0] + p.x;
                            int y1 = direction[k][1] + p.y;
                            if (x1 >= 0 && y1 >= 0 && x1 < row && y1 < col && board[x1][y1] == 'O') {
                                board[x1][y1] = 'N';
                                q.add(new Point(x1, y1));
                            }
                        }
                    }
                }
            }
        }


        //Since all marked O are now not connected to or not on border
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        //Reverting to original border O's
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }

        print(board);
    }

    public static void print(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char board[][] = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solve(board);

    }
}
