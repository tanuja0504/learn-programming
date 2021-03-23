package binarySearch;

public class HIndex2 {
    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int m = citations.length;
        int mid = 0;
        int ans = 0;
        while (left < right) {
            mid = left + ((right - left) / 2);
            System.out.println(mid + " " + left + " " + right);
            if (citations[mid] == m - mid) {
                ans = Math.max(mid, ans);
                break;
            } else if (citations[mid] > m - mid) {
                right = mid;
                ans = Math.max(mid + 1, ans);
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int citations[] = {1, 2, 100, 999, 1000};
        System.out.println(hIndex(citations));
    }
}
