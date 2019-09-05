package linkedList;

public class PrintReverseLinkedList {
    public void print(ListNode head) {
        if (head == null) {
            return;
        }
        print(head.next);
        System.out.print(head.val + "->");
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        PrintReverseLinkedList obj = new PrintReverseLinkedList();
        obj.print(list);

    }
}
