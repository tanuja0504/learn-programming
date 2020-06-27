package linkedList;

public class DuplicateNode {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (head != null || head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode p = null;
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);

        l = deleteDuplicates(p);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
