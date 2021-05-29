package dynamicProgramming.DigitDP;

public class NumberDigitOne {
    /*https://www.youtube.com/watch?v=ZOMKUPHcNRI&t=37s */

    /**
     * Calculate occurance on every digit, from
     * least important digit to most important digit
     * number = 1432
     * One's digit: n/10=143 143*1+1
     * Ten's digit: n/100=14 14*10+10
     * Hun's digit: n/1000=1 1*100+100
     * Tho's digit: 1432%1000+1=433
     * Sum all occurance on digits together
     */
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int result = 0;
        // process each digit of n, compute the total number of 1's can appear on that digit, and sum the results
        // solution inspired by StefanPochmann, but I rewrote his one-liner into if statements to help myself understand
        for (long m = 1; m <= n; m *= 10) {
            // suppose we have abcxdef
            // consider we are at m = 1000 (position x), then a = abcx, b = def
            long a = n / m, b = n % m;
            // if x > 1, then each combination of 0~abc (total abc+1 ways) on abc and 0~999 (total = 1000) on def works => (abc+1)*1000
            if (a % 10 > 1) {
                result += (a / 10 + 1) * m;
            }
            // if x == 1, then each combination of 0~(abc-1) (total abc ways) on abc and 0~999 (total = 1000) on def works => abc*1000
            // but when it comes to abc, since x == 1, we only have def+1 (including 0) ways the first three digits are abc, otherwise we will exceed the number n => def+1
            // total = abc*1000 + def+1
            if (a % 10 == 1) {
                result += (a / 10) * m + b + 1;
            }
            // if x == 0, this is the tricky part (IMO)
            // you can only have 0~(abc-1) (total abc ways) on abc and 0~999 (total = 1000) on def => abc*1000
            // this is because its still possible for x to be 1 on numbers less than abc0def
            // one example, assume i = c-1, then x can be 1 on the number abixdef
            // all the values from 0~abc-1 works, and thus we have abc*1000 ways.
            if (a % 10 == 0) {
                result += (a / 10) * m;
            }
        }
        return result;

    }
}
