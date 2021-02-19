package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        while (!st.isEmpty() || current != null) {
            while (current != null) {
                st.push(current);
                current = current.left;
            }
            current = st.pop();
            helper(result, new ArrayList<>(), current, sum);
            current = current.right;
        }
        count = result.size();
        System.out.println(result);
        return count;
    }

    public void helper(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum) {

        if (root == null) {
            return;
        }
        if (sum == root.val) {
            temp.add(root.val);
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(root.val);
        if (root.left != null) {
            helper(result, temp, root.left, sum - root.val);
            int size = temp.size() - 1;
            temp.remove(size);
        }
        if (root.right != null) {
            helper(result, temp, root.right, sum - root.val);
            int size = temp.size() - 1;
            temp.remove(size);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.right.left = new TreeNode(-2);
        PathSum3 obj = new PathSum3();
        System.out.println(obj.pathSum(root, -1));
    }
}
