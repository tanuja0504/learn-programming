package graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap(); // origin node : copied node
        Node myNode = new Node(node.val); // copy

        map.put(node, myNode);

        Queue<Node> q = new ArrayDeque(); // origin nodes
        q.add(node);

        // bfs traverse graph
        while (!q.isEmpty()) {
            Node cur = q.poll();
            // all neighbors of current origin node
            for (Node neighbor : cur.neighbors) {
                // if the origin node is not visited
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    // to avoid loop, we just add the unvisited node to queue
                    q.offer(neighbor);
                }
                // add neighbors to the copied node
                // copied node: map.get(cur) -> copied node of cur
                // neighbors: map.get(neighbor) -> copied node of neighbor
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return myNode;
    }
}
