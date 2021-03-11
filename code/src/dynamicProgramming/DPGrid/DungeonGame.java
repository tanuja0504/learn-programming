package dynamicProgramming.DPGrid;

public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int temp = 0;
                if (dp[i - 1][j] > 0) {
                    temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    temp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                dp[i][j] = temp - dungeon[i][j];
            }
        }
        print(dp);
        return dp[m - 1][n - 1];
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int[][] dungeon1 = {{-3, 5}};
        System.out.println(calculateMinimumHP(dungeon1));
    }
}
