package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens3 {
    //https://www.youtube.com/watch?v=yvt0emtFiIE By Sumeet Malik Pepcoding
    public static List<List<String>> solveNQueens(int n) {
        boolean visitedCol[] = new boolean[n];
        boolean visitedDiag[] = new boolean[(2 * n) - 1];
        boolean visitedRevDiag[] = new boolean[(2 * n) - 1];
        List<List<String>> result = new ArrayList<>();
        int row = 0;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        helper(result, visitedCol, visitedDiag, visitedRevDiag, row, board);
        return result;
    }

    public static void helper(List<List<String>> result, boolean visitedCol[], boolean visitedDiag[]
            , boolean visitedRevDiag[], int row, char board[][]) {

        if (board.length == row) {
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

        for (int col = 0; col < board[0].length; col++) {
            int boardLen = board.length - 1;
            if (!visitedCol[col] && !visitedDiag[row + col] && !visitedRevDiag[row - col + boardLen]) {
                visitedCol[col] = true;
                visitedDiag[col + row] = true;
                visitedRevDiag[row - col + boardLen] = true;
                board[row][col] = 'Q';

                helper(result, visitedCol, visitedDiag, visitedRevDiag, row + 1, board);
                board[row][col] = '.';
                visitedCol[col] = false;
                visitedDiag[col + row] = false;
                visitedRevDiag[row - col + boardLen] = false;
            }
        }
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
        System.out.println(solveNQueens(4));
    }
}
