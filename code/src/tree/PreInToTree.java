package tree;

import java.util.ArrayList;
import java.util.List;

public class PreInToTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        boolean visited[] = new boolean[preorder.length];
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode helper(int[] preorder, int[] inorder, int preIndex, int leftIndex, int rightIndex) {
        if (preIndex > preorder.length - 1 || leftIndex > rightIndex) {
            return null;
        }
        TreeNode temp = new TreeNode(preorder[preIndex]);
        int index = 0;
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (inorder[i] == temp.val) {
                index = i;
                break;
            }
        }
        temp.left = helper(preorder, inorder, preIndex + 1, leftIndex, index - 1);
        temp.right = helper(preorder, inorder, preIndex + 1, index + 1, rightIndex);
        return temp;
    }

    public static void print(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        print(root.left, result);
        result.add(root.val);
        print(root.right, result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        int preorder[] = {20, 15, 7};
        int inorder[] = {15, 20, 7};
        print(buildTree(preorder, inorder), new ArrayList<>());
    }
}
