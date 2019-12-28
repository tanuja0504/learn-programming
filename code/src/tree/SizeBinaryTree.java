package tree;

public class SizeBinaryTree {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int hleft = 0, hright = 0;
        while (left != null) {
            hleft++;
            left = left.left;
        }
        while (right != null) {
            hright++;
            right = right.left;
        }
        if (hleft == hright) {
            Math.pow(2, hright - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
