package linkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode head = obj.reverseList(list);
        while (head != null) {
            System.out.println(head.val + "->");
            head = head.next;
        }
    }
}
