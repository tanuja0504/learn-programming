package graph;

import java.util.Stack;

public class CourseSchedule {
    /*public int find(int parent[],int u){
        if(parent[u]==-1){
            return u;
        }
        return find(parent,parent[u]);
    }
    public void union(int parent[],int u,int v){
        parent[u]=v;
    }
    public boolean isCycle(int numCourses, int[][] prerequisites){
        if(prerequisites.length==0){
            return true;
        }
        int m=prerequisites.length;
        int parent[]=new int[numCourses];
        Arrays.fill(parent,-1);
        for(int i=0;i<m;i++){
            int x=find(parent,prerequisites[i][0]);
            int y=find(parent,prerequisites[i][1]);
            if(x==y && existInPath(parent,prerequisites[i][0],prerequisites[i][1])){
                return false;
            }
            union(parent,x,y);
            for(int j:parent){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return true;
    }
    private boolean existInPath(int[] graph, int idx1, int idx2)
    {
        while(graph[idx1]!=-1)
        {
            if(graph[idx1]==idx2)
                return true;
            idx1=graph[idx1];
        }
        return false;
    }*/

    public void topSort(int s, boolean visited[], boolean finished[], Stack<Integer> st, int matrix[][]) {

        visited[s] = true;
        int t = s;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[t][i] == 1 && !visited[t]) {
                topSort(i, visited, finished, st, matrix);
            }
        }

        st.push(s);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[numCourses];
        int matrix[][] = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (!visited[i]) {
                    topSort(i, visited, visited, st, matrix);
                }
            }
        }
        System.out.println(st);
        return (st.size() == numCourses) ? true : false;
    }


    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        int numCourse = 5;
        int[][] prerequisites1 = {{0, 2}, {1, 2}, {2, 0}};
        int numCourse1 = 3;
        System.out.println(obj.canFinish(numCourse1, prerequisites1));
    }
}
