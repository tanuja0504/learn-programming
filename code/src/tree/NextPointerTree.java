package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NextPointerTree {
    public Node connect(Node root) {
        helper(root);
        return root;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else if (root.next != null) {
                if (root.next.left != null) {
                    root.left.next = root.next.left;
                } else if (root.next.right != null) {
                    root.left.next = root.next.right;
                }
            }
        }
        if (root.right != null) {
            if (root.next.left != null) {
                root.right.next = root.next.left;
            } else if (root.next.right != null) {
                root.right.next = root.next.right;
            }
        }
        helper(root.left);
        helper(root.right);
    }

    public static Node connect1(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Node> list = new ArrayList<>();
            while (size > 0) {
                Node current = q.poll();
                if (!q.isEmpty()) {
                    current.next = q.peek();
                }
                list.add(current);
                size--;
            }
            for (Node n : list) {
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.right = new Node(6);
        root.left = new Node(8);
        System.out.println(connect1(root));
    }
}
