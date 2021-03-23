package dynamicProgramming.Fibonacci;

import tree.TreeNode;

public class HouseRobber3 {
    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.left != null) {
            val = val + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val = val + rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, (rob(root.left) + rob(root.right)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }
}
