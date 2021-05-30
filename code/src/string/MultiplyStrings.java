package string;

public class MultiplyStrings {
    /* https://leetcode.com/problems/multiply-strings/discuss/17608/AC-solution-in-Java-with-explanation
     */
   /* If we break it into steps, it will have the following steps.
   1. compute products from each pair of digits from num1 and num2.
   2. carry each element over.
   3. output the solution.
    Things to note:
    The product of two numbers cannot exceed the sum of the two lengths. (e.g. 99 * 99 cannot be five digit)

*/
    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("16", "4"));
    }
}
