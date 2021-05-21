package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {

            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }

            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }

            for (int col = right - 1; col >= left && top != bottom; col--) {
                result.add(matrix[bottom][col]);
            }

            for (int row = bottom - 1; row >= top + 1 && left != right; row--) {
                result.add(matrix[row][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
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

        System.out.println();
        int matrix1[][] = {{7}, {9}, {6}};
        int matrix2[][] = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }
}
