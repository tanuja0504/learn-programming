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
        copyRandomList(null);
        while (print != null) {
            System.out.print(print.val);
            if (print.random == null) {
                System.out.print(" null");
            } else
                System.out.print(" " + print.random.val);
            print = print.next;
            System.out.println();
        }
    }
}
