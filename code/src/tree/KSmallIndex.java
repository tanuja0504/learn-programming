package tree;

import java.util.ArrayList;
import java.util.List;

public class KSmallIndex {
    static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> result = new ArrayList<>();
        helper(root, k, result);
        return result.get(k).val;
    }

    public void helper(TreeNode root, int k, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        if (k == count) {
            return;
        }
        helper(root.left, k, result);
        result.add(root);
        count++;
        helper(root.right, k, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        KSmallIndex obj = new KSmallIndex();
        System.out.println(obj.kthSmallest(root, 7));
    }
}
