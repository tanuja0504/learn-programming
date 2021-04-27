package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {
    static int count = 0;

    public static int totalNQueens(int n) {
        List<char[][]> output = new ArrayList<>();
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        helper(0, board);
        return count;
    }

    public static void helper(int col, char board[][]) {
        if (board.length == col) {
            count++;
            return;
        }
        // Try placing the queen on each row of the column and check if the chessboard remains OK.
        for (int i = 0; i < board.length; i++) {
            board[i][col] = 'Q';
            if (verify(board, i, col)) {
                //Verified, hence place next queen in another column
                helper(col + 1, board);
            }
            board[i][col] = '.';
        }

    }

    public static boolean verify(char board[][], int i, int j) {
        boolean result = true;
        int col = j;
        int row = i;

        // Check if there is a queen 'Q' positioned to the left of column col
        // on the same row.
        for (int k = 0; k < col; k++) {
            if (board[row][k] == 'Q') {
                return false;
            }
        }
        // Check if there is queen 'Q' positioned on the upper left diagonal
        for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //verify lower left diagonal
        for (int r = i + 1, c = j - 1; r < board.length && c >= 0; r++, c--) {
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
        System.out.println(totalNQueens(4));
    }
}
