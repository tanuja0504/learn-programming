package linkedList;

public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid.next);
        ListNode list = merge(left, right);
        return list;
    }


    public static ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = slow;
        slow = slow.next;
        prev.next = null;
        return slow;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode list = new ListNode(0);
        ListNode head = list;
        while (left.next != null && right.next != null) {
            if (left.val > right.val) {
                list.next = right;
                right = right.next;
            } else {
                list.next = left;
                left = left.next;
            }
            list = list.next;
        }

        if (left.next != null) {
            list.next = left;
        }
        if (right.next != null) {
            list.next = right;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(3);

        ListNode head = sortList(n);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
