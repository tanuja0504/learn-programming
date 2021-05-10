package string;

import java.util.*;

public class WordPattern {
    //Only few people seem to know that Map.put and Set.add return something

    public boolean wordPattern(String pattern, String s) {
        Map<Object, Integer> dict = new HashMap<>();
        boolean result = true;
        String input[] = s.split(" ");
        if (input.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < input.length; i++) {
            Integer k = dict.putIfAbsent(pattern.charAt(i), i);
            Integer j = dict.putIfAbsent(input[i], i);
            if (k != null && j != null && !k.equals(j)) {
                return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*WordPattern obj=new WordPattern();
        String pattern="ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str="s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(obj.wordPattern(pattern,str));
*/
        int i = 127;
        Integer a = i;
        Integer b = i;
        System.out.println(a == b);
    }
}


