package tree;

import java.util.*;

public class ZigZagOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> l2r = new Stack<>();
        Stack<TreeNode> r2l = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        l2r.push(root);
        while (!l2r.isEmpty() || !r2l.isEmpty()) {
            List<Integer> listA = new ArrayList<>();
            while (!l2r.isEmpty()) {
                TreeNode s1 = l2r.pop();
                listA.add(s1.val);
                if (s1.left != null)
                    r2l.push(s1.left);
                if (s1.right != null)
                    r2l.push(s1.right);
            }
            if (listA.size() > 0)
                result.add(listA);
            List<Integer> listB = new ArrayList<>();
            while (!r2l.isEmpty()) {
                TreeNode s2 = r2l.pop();
                listB.add(s2.val);
                if (s2.right != null)
                    l2r.push(s2.right);
                if (s2.left != null)
                    l2r.push(s2.left);
            }
            if (listB.size() > 0)
                result.add(listB);
        }

        return result;
    }

    public static List<List<Integer>> zigzag(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        boolean changeDir = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                t.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (changeDir) {
                Collections.reverse(t);
                changeDir = !changeDir;
            }
            result.add(t);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(6);
        root.right.right = new TreeNode(-1);
        root.right.right.right = new TreeNode(8);
        System.out.println(zigzagLevelOrder(root));
        System.out.println(zigzag(root));
    }
}
