package binarySearch;

public class HIndex2 {
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int left = 0, right = citations.length;
        int n = citations.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == n - mid) return n - mid;
            if (citations[mid] < citations.length - mid) left = mid + 1;
            else right = mid;
        }
        return n - left;
    }

    public static void main(String[] args) {
        int citations[] = {1, 2, 100, 999, 1000};
        System.out.println(hIndex(citations));
    }
}
