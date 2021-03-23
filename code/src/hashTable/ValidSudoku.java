package hashTable;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        return validCol(board) && validRow(board) && validGrid(board);
    }

    public static boolean validRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Map<Character, Boolean> present = new HashMap<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && present.containsKey(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.' && !present.containsKey(board[i][j])) {
                    present.putIfAbsent(board[i][j], true);
                }
            }

        }
        return true;
    }

    public static boolean validCol(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            Map<Character, Boolean> present = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.' && present.containsKey(board[j][i])) {
                    return false;
                } else if (board[j][i] != '.' && !present.containsKey(board[j][i])) {
                    present.putIfAbsent(board[j][i], true);
                }
            }
        }
        return true;
    }

    public static boolean validGrid(char[][] board) {
        int r = 0;
        int c = 0;
        int count = 0;

        while (count < 9) {
            Map<Character, Boolean> present = new HashMap<>();
            r = 0;
            c = count;
            while (r < 9) {
                for (int i = r; i < 3 + r; i++) {
                    for (int j = c; j < 3 + c; j++) {
                        if (board[j][i] != '.' && present.containsKey(board[j][i])) {
                            return false;
                        } else if (board[j][i] != '.' && !present.containsKey(board[j][i])) {
                            present.putIfAbsent(board[j][i], true);
                        }
                    }
                }
                System.out.println(present);
                present.clear();
                r = r + 3;
            }
            count = count + 3;
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
        char board1[][] = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board1));
    }
}