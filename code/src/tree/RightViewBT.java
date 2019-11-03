package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class RtTreeNode {
    int val;
    RtTreeNode left;
    RtTreeNode right;

    RtTreeNode(int x) {
        val = x;
    }
}

public class RightViewBT {
    public static List<Integer> rightSideView(RtTreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<RtTreeNode> q = new LinkedList<>();
        RtTreeNode temp;
        if (root == null) {
            return result;
        }
        q.add(root);
        int height = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            result.add(q.peek().val);
            while (size-- > 0) {
                temp = q.poll();

                if (temp.right != null) {
                    q.add(temp.right);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
            }
            height++;
        }
        return result;
    }

    public static void main(String[] args) {
        RtTreeNode root = new RtTreeNode(1);
        root.left = new RtTreeNode(2);
        root.right = new RtTreeNode(3);
        root.left.right = new RtTreeNode(5);
        root.right.right = new RtTreeNode(4);
        List<Integer> list = rightSideView(root);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
