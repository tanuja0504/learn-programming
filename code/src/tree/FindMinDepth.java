package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindMinDepth {
    public static int minDepth(TreeNode root) {
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);

        while (!q.isEmpty()) {
            int level = q.size();
            height++; //Increase height
            for (int i = 0; i < level; i++) {
                TreeNode t = q.poll();
                if (t.left == null && t.right == null) {
                    return height;
                }
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(minDepth(root));
    }
}
