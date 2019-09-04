package linkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        ListNode slow = head;
        ListNode fast = head;
        if (head == null) {
            return result;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        //list.next.next.next.next.next=list.next.next;
        LinkedListCycle obj = new LinkedListCycle();
        System.out.println(obj.hasCycle(list));
        ListNode list2 = new ListNode(1);
        System.out.println(obj.hasCycle(list2));
    }
}
