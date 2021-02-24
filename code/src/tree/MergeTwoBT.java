package tree;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBT {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;

        TreeNode root = new TreeNode(getSum(root1, root2));
        root.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return root;
    }


    public int getSum(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 == null) {
            System.out.println("Sum=" + root1.val);
            return root1.val;
        } else if (root1 == null && root2 != null) {
            System.out.println("Sum=" + root2.val);
            return root2.val;
        } else {
            System.out.println("Sum=" + root1.val + " " + root2.val);
            return root1.val + root2.val;
        }
    }

    public static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        MergeTwoBT obj = new MergeTwoBT();
        helper(obj.mergeTrees(root1, root2), result);
        System.out.println(result);
    }
}
