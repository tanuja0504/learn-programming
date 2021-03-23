package binarySearch;

public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = -1;
        int ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            System.out.println(mid);
            if (!isBadVersion(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static boolean isBadVersion(int n) {
        return (n >= 1) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }
}
