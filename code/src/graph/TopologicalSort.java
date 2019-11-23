package graph;

import java.util.*;

class Graph {
    int V;
    LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
}

public class TopologicalSort {

    public void helperTopSort(int v, Boolean visited[], Stack stack, Graph g) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = g.adj[v].listIterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                helperTopSort(i, visited, stack, g);
            }
        }
        stack.push(v);
    }

    public void topSort(Graph G) {
        Boolean[] visited = new Boolean[G.V];
        for (int i = 0; i < G.V; i++) {
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < G.V; i++) {
            if (!visited[i]) {
                helperTopSort(i, visited, stack, G);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        TopologicalSort top = new TopologicalSort();
        top.topSort(g);
    }
}
