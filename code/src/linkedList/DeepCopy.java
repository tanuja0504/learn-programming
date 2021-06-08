package linkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopy {
    public static Node copyRandomList(Node head) {
        Node copy = new Node(100001);
        Node output = copy;
        Node randomOutput = copy;
        Map<Node, Integer> listMap = new HashMap<>();
        Map<Integer, Node> copyMap = new HashMap<>();
        Map<Integer, Integer> randomMap = new HashMap<>();
        Node original = head;
        Node mapRandom = head;
        int count = 0;
        while (original != null) {
            count++;
            listMap.put(original, count);
            original = original.next;
        }
        count = 0;
        while (mapRandom != null) {
            count++;
            randomMap.put(count, listMap.get(mapRandom.random));
            mapRandom = mapRandom.next;
        }
        listMap.clear();
        count = 0;
        while (head != null) {
            Node temp = new Node(head.val);
            temp.next = null;
            copy.next = temp;
            copy = copy.next;
            head = head.next;
            count++;
            copyMap.put(count, copy);
        }
        randomOutput = randomOutput.next;
        System.out.println(randomMap);
        for (int i = 1; i <= count; i++) {
            int randomIndex = 10001;
            if (randomMap.get(i) != null) {
                randomIndex = randomMap.get(i);
            }
            if (randomIndex != 10001) {
                randomOutput.random = copyMap.get(randomIndex);
            } else {
                randomOutput.random = null;
            }
            System.out.println(randomOutput.val + " " + i);
            randomOutput = randomOutput.next;
        }
        return output;
    }

    public static Node copyRandomListV2(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Node current = head;
        Node newCurrent = newHead;
        Node dummy = newCurrent;
        while (current != null) {
            newCurrent.next = current.next;
            current.next = dummy;
            current = newCurrent.next;
            if (current != null) {
                dummy = new Node(current.val);
                newCurrent = dummy;
            }
        }
        current = head;
        newCurrent = newHead;
        while (newCurrent.next != null) {
            if (current.random != null) {
                newCurrent.random = current.random.next;
            }
            current = current.next.next;
            newCurrent = newCurrent.next.next;
        }
        if (current.random != null) {
            newCurrent.random = current.random.next;
        }
        current = head;
        newCurrent = newHead;
        while (current.next != null && newCurrent.next != null) {
            current.next = current.next.next;
            current = current.next;
            newCurrent.next = newCurrent.next.next;
            newCurrent = newCurrent.next;
        }

        current.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Node n = new Node(7);
        n.next = new Node(13);
        n.next.next = new Node(11);
        n.next.next.next = new Node(10);
        n.next.next.next.next = new Node(1);
        n.random = n;
        n.next.random = null;
        n.next.next.random = n.next.next;
        n.next.next.next.random = n.next;
        n.next.next.next.next.random = n;
        Node print = n;
        //copyRandomList(null);


        Node printV2 = copyRandomListV2(n);
        while (printV2 != null) {
            System.out.print(printV2.val + " ");
            printV2 = printV2.next;
        }
    }
}
