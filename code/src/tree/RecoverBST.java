package tree;

public class RecoverBST {
    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public static void recoverTree(TreeNode root) {
        inorder(root);
        int x = first.val;
        first.val = second.val;
        second.val = x;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (first == null && root.val < prev.val) {
            //Going inorder so previous of root node will be its left child
            first = prev;
        }
        if (first != null && root.val < prev.val) {
            //Going inorder so previous of right node will be root
            second = root;
        }
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        recoverTree(root);
    }

}
