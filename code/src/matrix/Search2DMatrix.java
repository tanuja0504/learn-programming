package matrix;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        if (matrix[0][0] > target || matrix[m][n] < target) {
            return false;
        }
        if (m == 1 && n == 1 && matrix[m][n] == target) {
            return true;
        }
        if (m == 0 && matrix[m][n] == target) {
            return true;
        }

        int high = m;
        int low = 0;
        int mid = low + (high - low / 2);
        int row;
        while (low < high) {
            mid = low + (high - low / 2);
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }

        }

        row = (matrix[mid][0] > target ? low : mid);
        int col = -1;
        System.out.println(low);
        low = 0;
        high = matrix[0].length - 1;
        mid = -1;
        while (low < high) {
            mid = low + (high - low / 2);
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }

        }
        col = mid;
        /*for (int i = 0; i <= n; i++) {
            if (matrix[row][i] == target) {
                col=i;
            }
        }*/

        return (col > -1 && matrix[row][col] == target) ? true : false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int matrix1[][] = {{5}};
        int matrix3[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target3 = 5;
        int target = 11;
        System.out.println(searchMatrix(matrix1, target3));
    }
}
