package backtracking;

import java.util.Set;

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        helper(board);
    }

    public static boolean helper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char c = '1'; c <= '9'; c++) {

                    if (!isValidSudoku(board, i, j, c)) {
                        continue;
                    }
                    board[i][j] = c;
                    boolean isSolved = helper(board);
                    if (isSolved) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public static boolean containsInSet(Set<String> visited, int i, int j, char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("-");
        sb.append(j);
        sb.append("-");
        sb.append(c);
        return visited.contains(sb.toString());
    }

    public static void addInSet(Set<String> visited, int i, int j, char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("-");
        sb.append(j);
        sb.append("-");
        sb.append(c);
        visited.add(sb.toString());
    }

    public static void removeFromSet(Set<String> visited, int i, int j, char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("-");
        sb.append(j);
        sb.append("-");
        sb.append(c);
        visited.remove(sb.toString());
    }

    public static boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c) {
                return false;
            }
            if (board[row][i] == c) {
                return false;
            }
        }


        int blockId = (row / 3) * 3;
        int blockCol = (col / 3) * 3;
        for (int i = blockId; i < (row / 3 + 1) * 3; i++) {
            for (int j = blockCol; j < (col / 3 + 1) * 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        char board[][] = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
