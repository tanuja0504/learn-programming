package linkedList;

public class DuplicateNode2 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp;
        ListNode data = new ListNode(0);
        ListNode prev = data;
        data.next = head;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (prev.next == head) {
                prev = prev.next;
            } else {
                prev.next = head.next;
            }
            head = head.next;
        }
        return data.next;
    }

    public static void main(String[] args) {
        ListNode p = null;
        ListNode l = new ListNode(2);
        l.next = new ListNode(2);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next = new ListNode(4);

        l = deleteDuplicates(l);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
