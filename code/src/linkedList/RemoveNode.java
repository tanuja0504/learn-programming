package linkedList;

public class RemoveNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast != null) {
            while (fast != null) {
                prev = prev.next;
                slow = slow.next;
                fast = fast.next;
            }
        }
        prev.next = slow.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
//        list.next = new ListNode(2);
//        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);
//        list.next.next.next.next = new ListNode(5);
        int n = 1;
        list = removeNthFromEnd(list, n);
        while (list != null) {
            list = list.next;
            System.out.println(list.val);
        }
    }
}
