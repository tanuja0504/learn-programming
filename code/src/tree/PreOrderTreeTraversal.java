package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PreTreeNode {
    int val;
    PreTreeNode left;
    PreTreeNode right;

    PreTreeNode(int x) {
        val = x;
    }
}

public class PreOrderTreeTraversal {
    public static List<Integer> preorderTraversal(PreTreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<PreTreeNode> s = new Stack<>();
        if (root == null)
            return result;
        s.push(root);
        PreTreeNode temp;
        while (!s.isEmpty()) {
            temp = s.pop();
            result.add(temp.val);
            if (temp.right != null) {
                s.add(temp.right);
            }
            if (temp.left != null) {
                s.add(temp.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PreTreeNode root = new PreTreeNode(1);
        root.left = new PreTreeNode(2);
        root.right = new PreTreeNode(3);
        root.left.right = new PreTreeNode(5);
        root.right.right = new PreTreeNode(4);
        List<Integer> list = preorderTraversal(root);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
