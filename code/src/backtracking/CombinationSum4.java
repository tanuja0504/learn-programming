package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        boolean visited[] = new boolean[nums.length];
        helper(0, result, temp, visited, target, nums);
        System.out.println(result);
        return result.size();
    }

    public static void helper(int start, List<List<Integer>> result, List<Integer> temp, boolean visited[], int target, int nums[]) {
        if (target == 0) {
            System.out.println(temp);
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(i, result, temp, visited, target - nums[i], nums);
            int size = temp.size() - 1;
            temp.remove(size);
        }
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int combinationSum4DP(int[] nums, int target) {
        int m = nums.length;
        int n = target;
        Arrays.sort(nums);
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= n; j++) {
            //Doing this to get all combinations to obtain particular sum
            for (int i = 1; i <= m; i++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] + dp[m][j - nums[i - 1]];
                }
            }
        }

        print(dp);
        return dp[m][n];
    }

    public static int findCombination(int n, int i) {
        int result = 1;
        while (n > 0) {
            result = result * n;
            n--;
        }
        while (i > 0) {
            result = result / i;
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 4};
        int target = 32;
        System.out.println(combinationSum4DP(nums, target));
    }
}
