package binarySearch;

public class Practice {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        //if(target>nums[right])
        while (left <= right) {
            mid = left + ((right - left)) / 2;
            System.out.println(mid + " " + left + " " + right);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (nums[mid] == target) ? mid : -1;
    }

    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        int mid = left + ((right - left) / 2);
        int ans = 0;
        while (left <= right) {

            mid = left + ((right - left) / 2);
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = 0;

        while (left <= right) {
            mid = left + ((right - left) / 2);
            int t = guess(mid);
            if (t == 0) {
                return mid;
            } else if (t < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static int guess(int x) {
        int y = 9;
        int ans = 0;
        if (x == y) {
            ans = 0;
        } else if (x < y) {
            ans = -1;
        } else if (x > y) {
            ans = 1;
        }
        return ans;
    }

    public static int searchRotated(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                ans = mid;
                break;
            } else if (nums[mid] < target) {
                if (nums[right] < nums[mid]) {
                    left = mid + 1;
                } else {

                }

            } else if (nums[mid] > target) {

            }
        }
        return ans;
    }


    public static void main(String[] args) {
        //int arr[]={-1,0,3,5,9,12};
        //System.out.println(search(arr,13));
        //System.out.println(mySqrt(5));
        //System.out.println(guessNumber(Integer.MAX_VALUE));
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchRotated(arr, 0));
    }
}
