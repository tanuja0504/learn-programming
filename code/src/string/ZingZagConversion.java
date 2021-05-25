package string;

import java.util.Arrays;

public class ZingZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int numCols = 2 * (s.length() / numRows) + 1;
        char matrix[][] = new char[numRows][numCols];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            Arrays.fill(matrix[i], '-');
        }
        int t = 0;
        int row = 0;
        int col = 0;

        while (t < s.length()) {
            printMat(matrix);
            while (t < s.length() && row < numRows) {
                matrix[row][col] = s.charAt(t);
                row++;
                t++;
            }
            row = row - 2;
            col = col + 1;
            while (t < s.length() && row > 0) {
                matrix[row][col] = s.charAt(t);
                row--;
                t++;
            }
            col++;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '-') {
                    sb.append(matrix[i][j]);
                }
            }
        }
        printMat(matrix);
        return sb.toString();
    }

    static void printMat(char dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
