package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, new ArrayList<>(), targetSum);
        return result;
    }

    public void helper(TreeNode root, List<List<Integer>> result, List<Integer> temp, int targetSum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && targetSum == root.val) {
            temp.add(root.val);
            result.add(new ArrayList<>(temp));
            return;
        }
        targetSum = targetSum - root.val;
        temp.add(root.val);
        if (root.left != null) {
            helper(root.left, result, temp, targetSum);
            int size = temp.size() - 1;
            temp.remove(size);
        }
        if (root.right != null) {
            helper(root.right, result, temp, targetSum);
            int size = temp.size() - 1;
            temp.remove(size);
        }

        return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        PathSum2 obj = new PathSum2();
        System.out.println(obj.pathSum(root, 22));
    }
}
