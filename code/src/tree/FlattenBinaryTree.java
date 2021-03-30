package tree;

public class FlattenBinaryTree {
    public static void flatten(TreeNode root) {
        if (root == null || root.left == null) {
            return;
        }
        flatten(root.left);
        TreeNode t1 = root.right;
        root.right = null;
        root.right = root.left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = t1;
        root.left = null;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printInOrder(root.left);
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        //root.left.left=new TreeNode(3);
        //root.left.right=new TreeNode(4);
        //root.right.right=new TreeNode(6);
        printInOrder(root);
        System.out.println();
        flatten(root);
        printInOrder(root);
    }
}
