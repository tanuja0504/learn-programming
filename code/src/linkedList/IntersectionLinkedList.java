package linkedList;

public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode head = null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            tempA = tempA.next;
            countA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            countB++;
        }
        int diff = Math.abs(countA - countB);
        if (countA > countB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        if (countA < countB) {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                head = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        ListNode head = new ListNode(7);
        head.next = new ListNode(8);
        head.next.next = list.next.next.next.next;
        IntersectionLinkedList obj = new IntersectionLinkedList();
        System.out.println(obj.getIntersectionNode(list, head).val);
    }
}
