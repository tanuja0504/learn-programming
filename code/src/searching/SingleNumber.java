package searching;

/*Given a non-empty array of integers, every element appears twice except for one.class
Find that single one.
Input: [2,2,1]
Output: 1
*/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 1};
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(nums));
    }
}
