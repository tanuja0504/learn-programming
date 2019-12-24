package linkedList;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        ListNode listA = new ListNode(0);
        ListNode listB = new ListNode(0);
        MergeSortedList obj = new MergeSortedList();
        ListNode l = obj.mergeTwoLists(listA, listB);
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
    }
}
