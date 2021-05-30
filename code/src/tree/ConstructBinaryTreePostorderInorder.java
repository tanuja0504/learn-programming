package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConstructBinaryTreePostorderInorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }

        return root;
    }

    public static List<Integer> printTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        printTree(root.left, result);

        printTree(root.right, result);
        return result;
    }

    public static void main(String[] args) {
        int in[] = {9, 3, 15, 20, 7};
        int post[] = {9, 15, 7, 20, 3};
        System.out.println(printTree(buildTree(in, post), new ArrayList<>()));
    }
}
