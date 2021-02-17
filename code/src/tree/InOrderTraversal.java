package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s1.isEmpty()) {
            while (curr != null) {
                s1.push(curr);
                curr = curr.left;
            }
            curr = s1.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public static List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> l = inorderTraversalRec(root);
        System.out.println(l);
    }
}
