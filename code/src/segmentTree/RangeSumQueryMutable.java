package segmentTree;

//Segment Tree
public class RangeSumQueryMutable {

    int tree[];
    int n;

    //f we sum the number by level we will get: n+n/2+n/4+n/8+…+1≈2n
    public RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        tree = new int[2 * n];
        buildTree(nums);
        for (int i : tree) {
            System.out.println(i);
        }
    }

    public void buildTree(int[] nums) {
        //Initializing leaves with actual value of array which is range of one element
        for (int i = n, j = 0; i < 2 * n; i++, j++) {
            tree[i] = nums[j];
        }

        //Getting nodes initialized
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        //Update the leaf node
        index = index + n;
        tree[index] = val;
        while (index > 0) {
            int left = index;
            int right = index;
            //Because left child at 2i and right at 2i+1
            if (index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }

            tree[index / 2] = tree[left] + tree[right];
            index = index / 2;
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        left = left + n;
        right = right + n;
        //Beause same range can b given like [1,1]
        while (left <= right) {
            //Check range's left value is right child of tree.
            //If yes we dont need parent sum
            //It will be right child as 2i+1
            if ((left % 2) == 1) {
                sum = tree[left];
                left++;
            }
            if ((right % 2) == 0) {
                sum = tree[right];
                right--;
            }
            left = left / 2;
            right = right / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5};
        RangeSumQueryMutable obj = new RangeSumQueryMutable(nums);
        System.out.println(obj.sumRange(1, 2));

    }
}
