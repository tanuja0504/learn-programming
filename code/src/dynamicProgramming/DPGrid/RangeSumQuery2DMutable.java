package dynamicProgramming.DPGrid;

public class RangeSumQuery2DMutable {
    int dp[][];

    public RangeSumQuery2DMutable(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + matrix[0][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + matrix[i][0];
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }

        print(dp);
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row2 >= dp.length) {
            row2 = dp.length - 1;
        }
        if (col2 >= dp[0].length) {
            col2 = dp[0].length - 1;
        }
        int area = dp[row2][col2];

        if (row1 > 0) {
            area = area - dp[row1 - 1][col2];
        }
        if (col1 > 0) {
            area = area - dp[row2][col1 - 1];
        }
        //Since this portion getting substracted twice compensating by adding once
        if (row1 > 0 && col1 > 0) {
            area = area + dp[row1 - 1][col1 - 1];
        }
        return area;
    }

    public void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int matrix2[][] = {{-4, -5}};
        RangeSumQuery2DMutable obj = new RangeSumQuery2DMutable(matrix2);
        System.out.println();
        obj.print(matrix2);

        System.out.println(obj.sumRegion(0, 1, 0, 1));
    }
}
