package design;


import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

    //static
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);
        StringBuilder sb = new StringBuilder();
        while (!cache.isEmpty()) {
            TreeNode t = cache.poll();
            if (t != null) {
                sb.append(t.val + ",");
                cache.add(t.left);
                cache.add(t.right);
            } else {
                sb.append("null,");
                continue;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        if (data.length() == 1) {
            return new TreeNode(Integer.valueOf(data));
        }
        String[] input = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        q.offer(root);
        int i = 1;
        while (i < input.length - 1 && !q.isEmpty()) {
            TreeNode t = q.poll();
            if (!input[i].equals("null")) {
                int val = Integer.parseInt(input[i]);
                t.left = new TreeNode(val);
                q.add(t.left);
            }
            i++;
            if (!input[i].equals("null")) {
                int val = Integer.parseInt(input[i]);
                t.right = new TreeNode(val);
                q.add(t.right);
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right.left = new TreeNode(4);
        t.right.right = new TreeNode(5);

        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(2);

        String s = "4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2";
        System.out.println(serialize(t));
        //printTree(deserialize(s));
    }
}
