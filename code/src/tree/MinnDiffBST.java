package tree;

public class MinnDiffBST {
    static Integer result = Integer.MAX_VALUE;
    static Integer previous = null;

    public static int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (previous != null) {
            result = Math.min(result, Math.abs(root.val - previous));
        }
        previous = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return result;
    }

  /*  public static int minDiffInBST(TreeNode root) {
        Stack<TreeNode> result=new Stack<>();
        result.push(root);
        int maxFirst=root.val;
        int maxSecond=root.val;
        int min=maxFirst-maxSecond;
        while(!result.isEmpty()){
            TreeNode current=result.pop();
            System.out.println(current.val);
            if(maxFirst<current.val){
                maxSecond=maxFirst;
                maxFirst=current.val;
                min=maxFirst-maxSecond;
            }
            if(current.left!=null) {
                result.push(current.left);
            }
            if(current.right!=null) {
                result.push(current.right);
            }

        }
        return min;
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(90);
        root.left = new TreeNode(69);
        //root.right = new TreeNode(15);
        root.left.left = new TreeNode(49);
        root.left.right = new TreeNode(89);
        root.left.left.left = new TreeNode(52);
        System.out.println("Min " + minDiffInBST(root));
    }
}
