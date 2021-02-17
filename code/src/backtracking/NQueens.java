package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //Set for maintaining rows where queen is placed
        Set<Integer> row = new HashSet<>();
        List<String> temp = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '*';
            }
        }
        helper1(board, 0, 0, result, temp, n, row);
        /*for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='*' ){
                    System.out.println(i+" "+j);
                    helper1(board,i,j,result,temp,n);
                }
            }
        }*/
        return result;
    }

    public static void helper1(char[][] board, int indexI, int indexJ, List<List<String>> result, List<String> temp, int n, Set<Integer> row) {
        if (indexI == board.length || indexJ == board[0].length) {
            System.out.println("Returning at " + n);
            return;
        } else if (indexI == n || row.size() == n) {
            printBoard(board);
            return;
        } else {
            printBoard(board);
            for (int j = 0; j < board[0].length; j++) {
                if (board[indexI][j] == '.' || row.contains(indexI)) {
                    continue;
                }
                markBoard(board, indexI, j);
                board[indexI][j] = 'Q';
                row.add(indexI);
                helper1(board, indexI + 1, 0, result, temp, n, row);
                row.remove(indexI);
            }

        }
    }

    public static void helper(char[][] board, int indexI, int indexJ, List<List<String>> result, List<String> temp, int n) {
        printBoard(board);
        if (indexI == board.length || indexJ == board[0].length || board[indexI][indexJ] == '.') {
            System.out.println("Returning at " + n);
            return;
        } else if (n < 0) {
            System.out.println("Got n");
            result.add(convertListToBoard(board, temp));
            return;
        } else {

            for (int i = indexI; i < board.length; i++) {
                for (int j = indexJ; j < board[0].length; j++) {
                    if (board[i][j] == 'Q' || board[i][j] == '.') {
                        continue;
                    }
                    board[i][j] = 'Q';
                    markBoard(board, i, j);
                    helper(board, i + 1, j + 1, result, temp, n - 1);
                    unMarkBoard(board, indexI, indexJ);
                }

            }
        }
    }

    public static List<String> convertListToBoard(char[][] board, List<String> temp) {
        for (int i = 0; i < board.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                str.append(board[i][j]);
            }
            temp.add(str.toString());
        }
        return temp;
    }

    public static void markBoard(char[][] board, int idxI, int idxJ) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][idxJ] != 'Q')
                board[i][idxJ] = '.';
        }
        for (int j = 0; j < board.length; j++) {
            if (board[idxI][j] != 'Q')
                board[idxI][j] = '.';
        }
        while (idxJ < board[0].length && idxI < board.length) {
            if (board[idxI][idxJ] != 'Q')
                board[idxI][idxJ] = '.';
            idxI++;
            idxJ++;
        }
    }

    public static void unMarkBoard(char[][] board, int idxI, int idxJ) {
        for (int i = 0; i < board.length; i++) {
            board[i][idxJ] = '*';
        }
        for (int j = 0; j < board.length; j++) {
            board[idxI][j] = '*';
        }
        while (idxJ < board[0].length && idxI < board.length) {
            board[idxI][idxJ] = '*';
            idxI++;
            idxJ++;
        }
    }

    public static void unMarkBoard1(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '*';
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
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
