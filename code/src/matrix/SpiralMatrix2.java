package matrix;

public class SpiralMatrix2 {
    /*https://leetcode.com/problems/spiral-matrix/discuss/1105122/100-0ms-faster-O(n)-time-O(1)-space*/
    // print entire first row (can be cases of just a row)
    // print remaining right column (can be cases of just a column)
    // print remaining last row
    // print remaining left column
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int i = 1;
        while (left <= right && top <= bottom && i <= n * n) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = i;
                i++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = i;
                i++;
            }
            for (int col = right - 1; col >= left && top != bottom; col--) {
                matrix[bottom][col] = i;
                i++;
            }
            for (int row = bottom - 1; row > top && left != right; row--) {
                matrix[row][left] = i;
                i++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

    public static void print(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        print(matrix);
    }
}
