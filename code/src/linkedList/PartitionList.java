package linkedList;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode firstHead = new ListNode(0);
        ListNode secondHead = new ListNode(0);
        ListNode first = firstHead;
        ListNode second = secondHead;
        ListNode current = head;
        while (current != null) {
            ListNode tmp = current.next;
            if (current.val < x) {
                first.next = current;
                first = current;
            } else {
                second.next = current;
                second = current;
                second.next = null;
            }
            current = tmp;
        }
        first.next = secondHead.next;
        return firstHead;
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
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(4);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(2);
        partition(list, 3);
        printList(list);
    }
}
