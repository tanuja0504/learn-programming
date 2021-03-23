package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph1 {
    int V;
    LinkedList<Integer> adj[];

    Graph1(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        visited[s] = true;
        ((LinkedList<Integer>) q).push(s);
        while (!q.isEmpty()) {
            int t = q.poll();
            System.out.print(t + " ");
            Iterator<Integer> itr = adj[t].listIterator();
            while (itr.hasNext()) {
                int t1 = itr.next();
                if (!visited[t1]) {
                    ((LinkedList<Integer>) q).push(t1);
                    visited[t1] = true;
                }
            }
        }
    }

    public void dfs(int s) {
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];
        st.push(s);
        visited[s] = true;
        while (!st.isEmpty()) {
            int t = st.pop();
            System.out.print(t + " ");
            Iterator<Integer> itr = adj[t].listIterator();
            while (itr.hasNext()) {
                int t1 = itr.next();
                if (!visited[t1]) {
                    st.push(t1);
                    visited[t1] = true;
                }
            }
        }
    }
}

public class GraphList {

    public static void main(String[] args) {
        Graph1 g = new Graph1(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.bfs(2);
        System.out.println();
        g.dfs(1);
    }
}
