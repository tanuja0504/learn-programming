package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {
    static int count = 0;

    public static List<TreeNode> generateTrees(int n) {
        TreeNode root = new TreeNode(n);
        List<TreeNode> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {

        }
        print(helper(n, result, 1, "root"));
        return result;
    }

    public static TreeNode helper(int n, List<TreeNode> result, int current, String s) {
        if (current > n) {
            count++;
            return null;
        }
        TreeNode root = new TreeNode(current);
        System.out.println(s + " " + root.val);
        root.left = helper(n, result, current + 1, "left");
        root.right = helper(n, result, current + 2, "right");
        return root;
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> result = generateTrees(n);
        for (TreeNode root : result) {
            print(root);
            System.out.println();
        }
    }
}
