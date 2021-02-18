package tree;

import java.util.List;

public class SumRootToLeaf {
    static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        int temp = 0;
        return helper(root, temp);
    }

    public static void helper1(TreeNode root, List<List<Integer>> result, List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(temp);
        }
        System.out.println(result);
        if (root.left != null) {
            helper1(root.left, result, temp);
            int size = temp.size() - 1;
            temp.remove(size);
        }
        if (root.right != null) {
            helper1(root.right, result, temp);
            int size = temp.size() - 1;
            temp.remove(size);
        }
        return;
    }

    public static int helper(TreeNode root, int temp) {
        if (root == null) {
            return 0;
        }
        temp = 10 * temp + root.val;
        if (root.left == null && root.right == null) {
            sum = sum + temp;
        }
        helper(root.left, temp);
        helper(root.right, temp);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }
}
