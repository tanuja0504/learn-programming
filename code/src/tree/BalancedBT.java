package tree;

import java.util.List;

public class BalancedBT {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root) != -1;
    }

    public static void helper(TreeNode root, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root);
        helper(root.right, result);
    }

    public static boolean helper1(TreeNode root) {

        if (root == null) {
            return true;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        boolean result = Math.abs(left - right) < 2 && helper1(root.left) && helper1(root.right);
        return result;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(right - left) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static int findHeight(TreeNode root) {
        System.out.println("Calling");
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
}
