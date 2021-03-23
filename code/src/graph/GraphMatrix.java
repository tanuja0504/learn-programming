package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph2 {
    int V;
    int adj[][];

    Graph2(int v) {
        V = v;
        adj = new int[V + 1][V + 1];
    }

    public void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    public void bfs(int s) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        ((LinkedList<Integer>) q).push(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int t = q.poll();
            System.out.print(t + " ");
            for (int i = 0; i <= V; i++) {
                if (adj[t][i] == 1 && !visited[i]) {
                    ((LinkedList<Integer>) q).push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void dfs(int s) {
        boolean visited[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        st.push(s);
        visited[s] = true;
        while (!st.isEmpty()) {
            int t = st.pop();
            System.out.print(t + " ");
            for (int i = 0; i <= V; i++) {
                if (adj[t][i] == 1 && !visited[i]) {
                    st.push(i);
                    visited[i] = true;
                }
            }
        }
    }

}

public class GraphMatrix {
    public static void main(String[] args) {
        Graph2 g = new Graph2(4);
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
