package stack;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        TreeNode current = root;
        st.push(current);
        while (current.left != null) {
            current = current.left;
            st.push(current);
        }

    }

    public int next() {
        if (st.isEmpty()) {
            return new TreeNode(0).val;
        }
        TreeNode tempNode = st.pop();
        int next = tempNode.val;
        if (tempNode.right != null) {
            st.push(tempNode.right);
            tempNode = tempNode.right;
            while (tempNode.left != null) {
                st.push(tempNode.left);
                tempNode = tempNode.left;
            }
        }
        return next;
    }

    public boolean hasNext() {
        return !st.empty();
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator obj = new BSTIterator(root1);
        obj.next();
        System.out.println(obj.hasNext());
        obj.next();
    }

}
