package hashTable;

public class HIndex {
    public static int hIndex(int[] citations) {
        int result = 0;

        //Get max element for bucket size
        int max = Integer.MIN_VALUE;
        for (int cite : citations) {
            max = Math.max(cite, max);
        }

        if (citations.length == 0 || max == 0) {
            return result;
        }

        //Initialize bucket
        int bucket[] = new int[max + 1];

        //Sort citations
        for (int cite : citations) {
            bucket[cite]++;
        }

        for (int i : bucket) {
            System.out.print(i + " ");
        }
        System.out.println();
        //Update citations with how many papers hold more citations
        int count = 0;
        for (int i = 0; i < max; i++) {
            int t = citations.length - count;
            count = bucket[i] + count;
            bucket[i] = t;
        }
        for (int i : bucket) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] >= i) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int citations[] = {3, 0, 6, 1, 5};
        int citations1[] = {1, 1, 3};
        int citations2[] = {8, 8, 8, 8, 8, 1};
        System.out.println(hIndex(citations2));
    }
}
