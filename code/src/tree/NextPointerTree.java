package tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class NextPointerTree {

    public static Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        Node current = root;
        q.add(current);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (!q.isEmpty() && size >= 0) {
                Node temp = q.poll();
                if (!q.isEmpty()) {

                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                size--;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.right = new Node(6);
        root.left = new Node(8);
        System.out.println(connect(root));
    }
}
