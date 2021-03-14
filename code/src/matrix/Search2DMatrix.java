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
        boolean result = false;
        int high = m;
        int low = 0;
        int mid = low + (high - low / 2);
        int row = -1;
        while (low <= high) {
            if (matrix[mid][0] == target || (target <= matrix[mid][n] && target >= matrix[mid][n])) {
                result = true;
                break;
            } else if (matrix[mid][n] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low / 2);
        }
        row = mid;
        int col = -1;
        for (int i = 0; i <= n; i++) {
            if (matrix[row][i] == target) {
                col = i;
            }
        }
        return (col > -1 && matrix[row][col] == target) ? true : false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int matrix1[][] = {{1}, {2}, {11}};
        int target = 3;
        System.out.println(searchMatrix(matrix1, target));
    }
}
