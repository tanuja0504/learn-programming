package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int r = 0;
        int c = 0;
        while (r < row && c < column) {
            while (c < column) {
                System.out.print(matrix[r][c] + " ");
                c++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][4];
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = count;
                count++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        spiralOrder(matrix);
    }
}
