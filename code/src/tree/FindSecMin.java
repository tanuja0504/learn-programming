package tree;

public class FindSecMin {
    public static int findSecondMinimumValue(TreeNode root) {
        int result = -1;
        if (root == null) {
            return result;
        }
        if (root.left == null || root.right == null) {
            return -1;
        }
        if (root.left.val == root.val) {
            result = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            result = findSecondMinimumValue(root.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(7);
        System.out.println(findSecondMinimumValue(root));
    }

}
