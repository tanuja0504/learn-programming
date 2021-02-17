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

    public static int minDepth1(TreeNode root) {
        if (root == null) {
            System.out.println("Root null");
            return 0;
        } else {
            int a = minDepth(root.left);
            int b = minDepth(root.right);
            System.out.println("a " + a);
            return Math.min(a, b) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        //root.right.right = new TreeNode(3);
        //root.right.right.right = new TreeNode(4);
        System.out.println(minDepth1(root));
    }
}
