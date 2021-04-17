package graph;

public class BattleshipsBoard {
    public static int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                } else if (board[i][j] == 'X') {
                    visited[i][j] = true;
                    count++;
                    if (i < m - 1 && board[i + 1][j] == 'X') {
                        int k = i + 1;
                        while (k < m && board[k][j] == 'X') {
                            visited[k][j] = true;
                            k++;
                        }
                    } else if (j < n - 1 && board[i][j + 1] == 'X') {
                        int k = j + 1;
                        while (k < n && board[i][k] == 'X') {
                            visited[i][k] = true;
                            k++;
                        }
                    }
                    //printMat(visited);
                    //System.out.println();
                } else {
                    visited[i][j] = true;
                }
            }
        }
        return count;
    }

    public static void printMat(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " | ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        char board[][] = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        char board1[][] = {{'X'}};
        char board2[][] = {{'X', 'X', 'X', 'X'}, {'.', '.', '.', '.'}, {'X', '.', '.', 'X'}};
        System.out.println(countBattleships(board2));
    }
}
