package linkedList;

public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mHead = dummy;
        ListNode nHead = dummy;
        ListNode mPrevious = mHead;
        ListNode nPrevious;
        if (m == n) {
            return dummy.next;
        }
        while (m > 0) {
            mPrevious = mHead;
            mHead = mHead.next;
            m--;
        }

        while (n > 0) {
            nHead = nHead.next;
            n--;
        }
        mPrevious.next = null;
        nPrevious = nHead.next;
        nHead.next = null;
        mHead = reverse(mHead);
        mPrevious.next = mHead;
        while (mHead.next != null) {
            mHead = mHead.next;
        }
        mHead.next = nPrevious;
        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = current;
            current = head;
            head = temp;
        }
        return current;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
//        list.next = new ListNode(2);
//        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);
//        list.next.next.next.next = new ListNode(5);
//        list.next.next.next.next.next = new ListNode(6);

        ListNode head = reverseBetween(list, 1, 1);
        while (head != null) {
            System.out.println(head.val + "->");
            head = head.next;
        }
    }
}
