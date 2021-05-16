package dynamicProgramming.DPGrid;

public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];
        int health = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 && dungeon[i][j] < 1) {
                    health = dungeon[0][0] * -1 + 1;
                }

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
