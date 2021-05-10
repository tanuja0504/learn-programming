package tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreePostorderInorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, inorder.length - 1, postorder.length - 1, inorder, postorder, "root");
    }

    public static TreeNode helper(int iStart, int iEnd, int pEnd, int[] inorder, int[] postorder, String s) {
        if (iStart > iEnd || pEnd < 0 || pEnd > postorder.length || iEnd >= inorder.length) {
            System.out.println("Failing for " + s);
            return null;
        }

        int val = postorder[pEnd];
        TreeNode root = new TreeNode(val);
        System.out.println(s);
        int index;
        for (index = iStart; index <= iEnd; index++) {
            if (val == inorder[index]) {
                break;
            }
        }
        int t = pEnd - (index - iStart) - 1;
        root.right = helper(index, iEnd, pEnd - 1, inorder, postorder, "right with root " + val + " " + index + " " + iEnd);
        root.left = helper(iStart, index - 1, t, inorder, postorder, "left with root " + val + " " + " " + iStart);
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

        int pre1[] = {};
        int in1[] = {};
        System.out.println(printTree(buildTree(in, post), new ArrayList<>()));
    }
}
