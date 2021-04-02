package heap;

import java.util.PriorityQueue;

public class KthSmallestInMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2}, {1, 3}};
        System.out.println(kthSmallest(matrix, 4));
    }
}
