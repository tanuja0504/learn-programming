package linkedList;

public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode current = head;
        if (head.next == null || head.next.next == null) {
            return;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow=slow.next;
        slow = reverse(slow);
        while (slow.next != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = slow;
            slow = slow.next;
            temp.next.next = current;
        }
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
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);
//        list.next.next.next.next = new ListNode(5);
//        list.next.next.next.next.next = new ListNode(6);

        reorderList(list);
        while (list != null) {
            System.out.println(list.val + "->");
            list = list.next;
        }
    }
}
