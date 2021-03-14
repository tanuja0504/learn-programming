package array;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        while (m > 0 && n > 0 && len > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[len - 1] = nums1[m - 1];
                m--;
                len--;
            } else {
                nums1[len - 1] = nums2[n - 1];
                n--;
                len--;
            }
        }
        while (n > 0) {
            nums1[len - 1] = nums2[n - 1];
            n--;
            len--;
        }
        while (m > 0) {
            nums1[len - 1] = nums1[m - 1];
            m--;
            len--;
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        merge(nums1, 3, nums2, nums2.length);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
