package tree;

import java.util.*;

public class DeepestNodes {
    public static int deepestLeavesSum(TreeNode root) {
        int sum = 0;
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
        List<Integer> list = output.pop();
        for (int num : list) {
            sum = sum + num;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(deepestLeavesSum(root));
    }
}
