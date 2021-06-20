package graph;

import java.util.*;

public class CourseSchedule2 {
    //Kahn's algorithm
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int result[] = new int[numCourses];
        Arrays.fill(result, -1);
        //For processing nodes
        Queue<Integer> q = new LinkedList<>();

        //Creating adjacency list & translating inputs
        Map<Integer, List<Integer>> inDegree = new HashMap<>();
        int innode[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree.get(prerequisites[i][1]).add(prerequisites[i][0]);
            innode[prerequisites[i][0]]++;
        }
        //Add all nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (innode[i] == 0) {
                q.add(i);
            }
        }
        int start = 0;
        while (!q.isEmpty()) {
            int element = q.poll();
            result[start] = element;
            start++;
            List<Integer> temp = inDegree.get(element);
            for (int i : temp) {
                innode[i]--;
                if (innode[i] == 0) {
                    q.add(i);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (result[i] == -1) {
                return new int[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int pre[][] = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int num = 4;
        System.out.println(findOrder(num, pre).length);
    }
}
