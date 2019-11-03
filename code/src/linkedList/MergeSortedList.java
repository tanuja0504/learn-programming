package linkedList;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode head = list;
        while (l1 != null && l2 != null) {
            list = list.next;
            if (l1.val <= l2.val) {
                list.val = l1.val;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                list.val = l2.val;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            list = l1;
            list = list.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            list = l2;
            list = list.next;
            l2 = l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        MergeSortedList obj = new MergeSortedList();
        ListNode l = obj.mergeTwoLists(list, head);
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
    }
}
