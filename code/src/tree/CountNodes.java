package tree;

public class CountNodes {
    static int height = 0;

    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        } else if (root.right != null) {
            int x = (int) Math.pow(2, height);
            height++;
            System.out.println("Nodes now " + x);
            return (x + 1 + countNodes(root.right));
        } else {
            return 1 + countNodes(root.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(6);
        root.right.right = new TreeNode(-1);
        root.right.right.right = new TreeNode(8);
        System.out.println(countNodes(root));
    }
}
