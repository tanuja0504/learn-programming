package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(result, root, new ArrayList<>());
        return result;
    }

    public static String helper(List<String> result, TreeNode root, List<Integer> temp) {
        if (root == null) {
            return "";
        }

        temp.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder s = new StringBuilder();
            s.append(temp.get(0));
            for (int i = 1; i < temp.size(); i++) {
                s.append("->" + temp.get(i));
            }
            result.add(s.toString());
        }
        if (root.left != null) {
            helper(result, root.left, temp);
            int size = temp.size() - 1;
            temp.remove(size);
        }
        if (root.right != null) {
            helper(result, root.right, temp);
            int size = temp.size() - 1;
            temp.remove(size);
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
    }
}
