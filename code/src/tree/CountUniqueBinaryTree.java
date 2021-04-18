package tree;

public class CountUniqueBinaryTree {
    public static int numTrees(int n) {
        //Count Number of Binary Search Trees with N Nodes Dynamic Programming - Catalan Numbers By Pep Coding
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int low = 0;
            int high = i - 1;
            while (low <= i - 1) {
                dp[i] += dp[low] * dp[high];
                low++;
                high--;
            }
        }
        return dp[n];
    }

    public static int helper(int start, int end) {
        if (start > end) {
            return 1;
        }
        if (end - start == 1) {
            return 1;
        }
        if (end - start == 2) {
            return 2;
        }
        int count = 0;
        for (int i = 2; i < end + 1; i++) {
            int a = helper(start, i - 1);
            int b = helper(i + 1, end);
            count = count + (a * b);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
        System.out.println(helper(0, 4));
    }
}
