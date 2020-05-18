package heap;

public class HeapSort {
    public void heapSort(int nums[]) {
        int size = nums.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(nums, i, size - 1);
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, 0, i);
        }
    }

    public void heapify(int arr[], int start, int end) {
        int largest = start;
        int lchild = 2 * start + 1;
        int rchild = 2 * start + 2;
        if (lchild < end && rchild < end) {
            if (arr[largest] < arr[lchild] || arr[largest] < arr[rchild]) {
                if (arr[rchild] < arr[lchild]) {
                    swap(arr, largest, lchild);
                    heapify(arr, lchild, end);
                } else if (arr[rchild] > arr[lchild]) {
                    swap(arr, largest, rchild);
                    heapify(arr, rchild, end);
                }
            }
        }
    }

    void heapify1(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify1(arr, n, largest);
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        HeapSort obj = new HeapSort();
        obj.heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
