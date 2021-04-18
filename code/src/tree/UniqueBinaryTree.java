package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTree {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        boolean visited[] = new boolean[n + 1];
        visited[0] = true;
        TreeNode node = new TreeNode();
        result = helper(1, n);
        return result;
    }

    public static List<TreeNode> helper(int start, int end) {
        if (start > end) {
            List<TreeNode> result = new ArrayList<>();
            result.add(null);
            return result;
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> l = helper(start, i - 1);
            List<TreeNode> r = helper(i + 1, end);

            //Generate all trees for n
            for (TreeNode l1 : l) {
                for (TreeNode r1 : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = l1;
                    root.right = r1;
                    result.add(root);
                }
            }
        }

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
        List<TreeNode> result = generateTrees(3);
        for (TreeNode n : result) {
            List<Integer> r = new ArrayList<>();
            helper(n, r);
            System.out.println(r);
        }
    }
}
