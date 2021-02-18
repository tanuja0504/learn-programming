package tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) return true;
        else return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static boolean hasPathSum1(TreeNode root, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        System.out.println(sum);

        if (root.left == null && root.right == null) {
            sum = sum - root.val;
        }

        return hasPathSum1(root.left, sum) || hasPathSum1(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        hasPathSum1(root, 22);
    }
}
