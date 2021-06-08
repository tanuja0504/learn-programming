package linkedList;

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        n.next.next.next.next.next.next = new ListNode(7);
        n.next.next.next.next.next.next.next = new ListNode(8);
        ListNode l = oddEvenList(n);
        while (l.next != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }

    }
}
