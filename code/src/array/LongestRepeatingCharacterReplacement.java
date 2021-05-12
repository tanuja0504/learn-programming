package array;

public class LongestRepeatingCharacterReplacement {
    /*The problem says that we can make at most k changes to the string (any character can be replaced with any other character).
    So, let's say there were no constraints like the k.
    Given a string convert it to a string with all same characters with minimal changes. The answer to this is
    length of the entire string - number of times of the maximum occurring character in the string
    Given this, we can apply the at most k changes constraint and maintain a sliding window such that
    (length of substring - number of times of the maximum occurring character in the substring) <= k*/

    public static int characterReplacement(String s, int k) {
        int maxOccuringChar = 0;
        int start = 0;
        int end = 0;
        int result = 0;
        int input[] = new int[26];

        //Keep a track of max occuring char in the window
        for (end = start; end < s.length(); end++) {
            //We update count of each character in bucket input
            int t = s.charAt(end) - 'A';
            input[t]++;
            maxOccuringChar = Math.max(maxOccuringChar, input[t]);
            //If window size - maxOccuringChar is > k we need to slide window
            //from left to right
            //Otherwise we keep growing window which is taken care by for loop
            if (end - start + 1 - maxOccuringChar > k) {
                input[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
}
