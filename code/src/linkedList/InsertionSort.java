package linkedList;

public class InsertionSort {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        ListNode prev = dummy;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            while (prev.next != null && current.val > prev.val) {
                prev = prev.next;
            }
            ListNode n = current.next;
            current.next = prev.next;
            prev.next = current;
            next = current.next;
            current = next;
        }
        return dummy.next;
    }

    public static void printList(ListNode list) {
        System.out.print("List-->");
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(-1);
        list.next = new ListNode(5);
        list.next.next = new ListNode(9);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(0);
        insertionSortList(list);
        printList(list);
    }
}
