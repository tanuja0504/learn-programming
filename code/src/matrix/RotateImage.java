package matrix;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return;
        }
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp1 = matrix[i][j];
                int temp2 = matrix[n - 1 - j][i];
                int temp3 = matrix[n - 1 - i][n - 1 - j];
                int temp4 = matrix[j][n - 1 - i];
                matrix[i][j] = temp2;
                matrix[j][n - 1 - i] = temp1;
                matrix[n - 1 - i][n - 1 - j] = temp4;
                matrix[n - 1 - j][i] = temp3;
            }
        }
    }

    public static void print(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(matrix);
        System.out.println();
        rotate(matrix);
        print(matrix);
    }
}
