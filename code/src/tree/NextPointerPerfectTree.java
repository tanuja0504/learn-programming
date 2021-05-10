package tree;

public class NextPointerPerfectTree {

    //Thought Process is to process current node's children and than send them in recursion
    public static Node connect(Node root) {
        helper(root);
        return root;
    }

    public static void helper(Node root) {
        if (root == null || root.right == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.left.right != null) {
                root.left.right.next = root.left.next.left;
            }
        }
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        helper(root.left);
        helper(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.right = new Node(6);
        root.left = new Node(8);
        System.out.println(connect(root).left.val);
    }
}
