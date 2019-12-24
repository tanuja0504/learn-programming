package linkedList;

/*
  Definition for singly-linked list.
 */

public class DeleteNodeValue {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
