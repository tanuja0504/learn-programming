package BitManipulation;

public class MaximumProductOfWordLengths {
    /*
    Main Idea:

1. use 1bit to represent each letter,
and use 32bit(Int variable, bitMap[i]) to represent the set of each word
2. if the ANDing of two bitmap element equals to 0,
these two words do not have same letter,
then calculate the product of their lengths
     */
    public int maxProduct(String[] words) {
        int[] bitMap = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bitMap[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < bitMap.length; i++) {
            for (int j = i + 1; j < bitMap.length; j++) {
                if ((bitMap[i] & bitMap[j]) == 0) {
                    result = Math.max(words[i].length() * words[j].length(), result);
                }
            }
        }
        return result;
    }
}
