package dynamicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelope {
    class Envelope {
        int x;
        int y;
    }

    class EnvelopeComparator implements Comparator<Envelope> {

        @Override
        public int compare(Envelope o1, Envelope o2) {
            return Integer.compare(o1.x, o2.x);
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        Envelope t[] = new Envelope[m];
        for (int i = 0; i < m; i++) {
            t[i] = new Envelope();
            t[i].x = envelopes[i][0];
            t[i].y = envelopes[i][1];
        }
        Arrays.sort(t, new EnvelopeComparator());
        for (int i = 0; i < m; i++) {
            System.out.println(t[i].x + " " + t[i].y);
        }
        int dp[] = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            int j = 0;
            while (j < i) {
                EnvelopeComparator o = new EnvelopeComparator();
                //int compare=o.compare(t[i],t[j]);
                if (t[i].x > t[j].x && t[i].y > t[j].y) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
                j++;
            }
        }

        int result = dp[0];
        for (int i = 1; i < m; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    static void printMat(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int envelopes[][] = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int envelopes2[][] = {{10, 17}, {10, 19}, {16, 2}, {19, 18}, {5, 6}};
        int envelopes3[][] = {{8, 3}, {3, 20}, {15, 5}, {11, 2}, {19, 6}, {9, 18}, {1, 19}, {13, 3}, {14, 20}, {6, 7}};
        RussianDollEnvelope obj = new RussianDollEnvelope();
        System.out.println(obj.maxEnvelopes(envelopes3));
    }
}
