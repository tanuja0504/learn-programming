package tree;

import java.util.Stack;

public class FlattenBinaryTree {

    public static void flatten2(TreeNode root) {
        Stack<TreeNode> q = new Stack<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            System.out.println("Processing " + st.peek().val);
            if (st.peek().right != null) {
                q.add(st.peek().right);
            }
            if (st.peek().left != null) {
                q.add(st.peek().left);
            }
            if (q.isEmpty()) {
                break;
            } else {
                st.peek().right = q.peek();
                st.pop().left = null;
                st.push(q.pop());
            }
        }
    }

    public static void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> q = new Stack<>();
        q.add(root);
        if (q.peek().left != null) {
            q.add(root.left);
            flatten1(q.peek().left);
        }
        if (q.peek().right != null) {
            q.add(root.right);
            flatten1(q.peek().right);
        }
        q.peek().left = null;
        q.pop().right = q.peek();
    }


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
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        printInOrder(root);
        System.out.println();
        flatten2(root);
        printInOrder(root);
    }
}
