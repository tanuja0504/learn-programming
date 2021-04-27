package backtracking;

import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        helper(result, board, 0);
        return result;
    }

    public static void helper(List<List<String>> result, char board[][], int col) {
        if (board.length == col) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            board[i][col] = 'Q';

            List<String> list = new ArrayList<>();
            for (int i1 = 0; i1 < board.length; i1++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i1][j]);
                }
                list.add(sb.toString());
            }
            result.add(list);

            if (verify(board, i, col)) {
                helper(result, board, col + 1);
            }
            board[i][col] = '.';
        }
    }

    public static boolean verify(char board[][], int row, int col) {
        boolean result = true;
        //Check queen in previous columns
        for (int c = 0; c < col; c++) {
            if (board[row][c] == 'Q') {
                return false;
            }
        }
        //Check queen in diagonal upper left
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //Check queen in diagonal lower left
        for (int r = row + 1, c = col - 1; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return result;
    }

    public static void printBoard(char[][] board) {
        System.out.println("Printing..");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
