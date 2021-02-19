package tree;

public class PathSum {

    //Online
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) return true;
        else return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

    //By self
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.val > targetSum && root.left == null && root.right == null) {
            return false;
        } else if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        } else {
            targetSum = targetSum - root.val;
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        }
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
        PathSum obj = new PathSum();
        System.out.println(obj.hasPathSum(root, 22));
    }
}
