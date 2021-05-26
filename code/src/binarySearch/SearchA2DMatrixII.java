package binarySearch;

public class SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    // Check the middle element of the matrix, if not found,
    // recursively call on sub matrices where
    // the value could still exist.
    // You will realize that the resultant possible places will
    // form a L shape on the original matrix.
    // This L shape can be broken down into 2 matrices.
    // If number found in any of the 2 matrices, we return true.

    public static boolean helper(int[][] matrix, int target, int rLow, int cLow, int rHigh, int cHigh) {
        if (rLow > rHigh || cLow > cHigh || rLow < 0 || cLow < 0 || rHigh > matrix.length || cHigh > matrix[0].length) {
            return false;
        }
        int rMid = rLow + ((rHigh - rLow) / 2);
        int cMid = cLow + ((cHigh - cLow) / 2);
        if (matrix[rMid][cMid] == target) {
            return true;
        } else if (matrix[rMid][cMid] < target) {
            return helper(matrix, target, rLow, cMid + 1, rHigh, cHigh) ||
                    helper(matrix, target, rMid + 1, cLow, rHigh, cHigh);
        } else if (matrix[rMid][cMid] > target) {
            return helper(matrix, target, rLow, cLow, rHigh, cMid - 1) ||
                    helper(matrix, target, rLow, cLow, rMid - 1, cHigh);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 5));
    }
}
