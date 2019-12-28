package tree;

import java.util.*;

public class BinaryTreeLevelOrderReverse {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> output = new Stack<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode n = q.poll();
                temp.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            output.add(temp);
        }
        while (!output.isEmpty()) {
            result.add(output.pop());
        }
        return result;
    }
}
