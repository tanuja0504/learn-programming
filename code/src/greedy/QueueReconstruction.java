package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueReconstruction {
    class CustomComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        }

    }

    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new CustomComparator());
        for (int[] a : people) {
            pq.offer(a);
        }
        int result[][] = new int[people.length][2];
        int visited[] = new int[people.length];
        Arrays.fill(visited, -1);
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            int t[] = pq.poll();
            System.out.println(t[0] + " " + t[1]);
            int height = t[0];
            int peopleCount = t[1] + 1;
            int s = peopleCount;
            int j;
            for (j = 0; j < size; j++) {
                if (visited[j] >= height || visited[j] == -1) {
                    s--;
                }
                if (s <= 0) {
                    break;
                }
            }
            visited[j] = height;
            result[j][0] = height;
            result[j][1] = peopleCount - 1;
            for (int v : visited) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        return result;
    }

    public static void main(String[] args) {
        int people[][] = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        QueueReconstruction obj = new QueueReconstruction();
        int result[][] = obj.reconstructQueue(people);
        for (int i[] : result) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
