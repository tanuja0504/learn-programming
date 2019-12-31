package tree;

public class DiameterBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int lheight = maxDepth(root.left);
        int rheight = maxDepth(root.right);
        int ldiameter = diameterOfBinaryTree(root.left);
        int rdiameter = diameterOfBinaryTree(root.right);
        System.out.println("Via Root" + (lheight + rheight + 1));
        return Math.max(lheight + rheight, Math.max(ldiameter, rdiameter));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        DiameterBinaryTree obj = new DiameterBinaryTree();
        System.out.println(obj.diameterOfBinaryTree(root));
    }
}
