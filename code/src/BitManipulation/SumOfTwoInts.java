package BitManipulation;

public class SumOfTwoInts {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b; //For  negative cases
            b = carry << 1;
        }
        return a;
    }
}
