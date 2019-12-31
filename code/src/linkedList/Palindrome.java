package linkedList;

import java.util.Stack;

public class Palindrome {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = middleNode(head);
        Stack<ListNode> s = new Stack<>();
        ListNode temp = mid;
        while (mid != null) {
            s.push(mid);
            mid = mid.next;
        }
        while (!s.isEmpty() && head != null && head != temp) {
            if (s.pop().val == head.val) {
                head = head.next;
            } else
                break;
        }
        if (s.isEmpty() && head == temp) {
            return true;
        } else if (s.size() == 1 && head == temp) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(0);
        list.next.next = new ListNode(1);
        Palindrome obj = new Palindrome();
        System.out.println(obj.isPalindrome(list));
    }
}
