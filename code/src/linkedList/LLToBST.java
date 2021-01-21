package linkedList;

/*
 * Definition for singly-linked list.
 */
/*class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }*/

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LLToBST {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        TreeNode root = helper(head, null);
        return root;
    }

    public static TreeNode helper(ListNode start, ListNode end) {
        if (start == null || start == end) {
            return null;
        }
        ListNode mid = middleNode(start, end);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(start, mid);
        root.right = helper(mid.next, end);
        return root;
    }

    public static ListNode middleNode(ListNode start, ListNode end) {
        if (start == end) {
            return start;
        }
        ListNode fast = start;
        while (fast != null && fast.next != end && fast != end) {
            fast = fast.next.next;
            start = start.next;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(-10);
        list.next = new ListNode(-3);
        list.next.next = new ListNode(0);
        list.next.next.next = new ListNode(5);
        list.next.next.next.next = new ListNode(9);
        TreeNode t = sortedListToBST(list);
        System.out.println(t.left.val);
    }
}
