package searching;
/*
Suppose an array sorted in ascending order is rotated at
some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search.
If found in the array return its index, otherwise return -1.*/

public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int result = -1;
        int front = 0;
        int back = nums.length;
        while (front < back) {
            int mid = (front + back) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            } else if (nums[front] < nums[mid - 1]) {
                mid = (front + (mid - 1)) / 2;
            } else if (nums[front] < nums[mid - 1]) {
                mid = (front + (mid - 1)) / 2;
            }
        }
        return result;
    }
}
