package linkedList;

public class LinkedListCycleStart {
    public ListNode hasCycle(ListNode head) {
        boolean result = false;
        ListNode temp = null;
        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                result = true;
                break;
            }
        }
        if (result != true) {
            return null;
        } else {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            temp = slow;
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
        list.next.next.next.next.next = list.next.next;
        LinkedListCycleStart obj = new LinkedListCycleStart();
        System.out.println(obj.hasCycle(list).val);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = list2;
        System.out.println(obj.hasCycle(list2).val);
    }
}
