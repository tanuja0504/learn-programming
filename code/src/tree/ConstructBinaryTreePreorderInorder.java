package tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreePreorderInorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int pStart, int pEnd, int iStart, int iEnd, int[] preorder, int[] inorder) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int val = preorder[pStart];
        TreeNode root = new TreeNode(val);
        int index;
        for (index = iStart; index < iEnd; index++) {
            if (val == inorder[index]) {
                break;
            }
        }
        //Length of index will denote root node
        //Length of left= 0...index=left
        //Length of right= index+1.....end=right
        index = index - iStart;
        //Before Index its left part in Inorder
        root.left = helper(pStart + 1, pStart + index, iStart, iStart + index, preorder, inorder);
        //After Index its right part in Inorder
        root.right = helper(pStart + index + 1, pEnd, iStart + index + 1, iEnd, preorder, inorder);
        return root;
    }

    public static List<Integer> printTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }

        printTree(root.left, result);
        result.add(root.val);
        printTree(root.right, result);
        return result;
    }

    public static void main(String[] args) {
        int pre[] = {3, 9, 20, 15, 7};
        int in[] = {9, 3, 15, 20, 7};
        int pre1[] = {};
        int in1[] = {};
        System.out.println(printTree(buildTree(pre1, in1), new ArrayList<>()));
    }
}
