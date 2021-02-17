package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        boolean result = true;
        if (root == null) {
            return true;
        }
        TreeNode current = root;
        while (current != null || !st.isEmpty()) {
            while (current != null) {
                st.push(current);
                current = current.left;
            }
            current = st.pop();
            list.add(current.val);
            current = current.right;
        }

        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }

        return result;
    }

    public static boolean isValidBST1(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, int min, int max) {
        if (root == null || (root.right == null && root.left == null)) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        boolean a = helper(root.left, min, root.val);
        boolean b = helper(root.right, root.val, max);
        return a && b;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(isValidBST1(root));
    }
}
