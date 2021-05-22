package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        helper(new StringBuilder(), s, 0, 0, list);
        return list;
    }

    public static void helper(StringBuilder sb, String s, int count, int start, List<String> list) {
        if (start != s.length() + 3 && count == 4) {
            return;
        }
        if (start >= s.length() && count == 3) {
            list.add(new String(sb.toString()));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String part = s.substring(start, i + 1);
            int prevLen = sb.length();
            if (part.length() > 3 || Integer.parseInt(part) > 255) {
                return;
            }
            if (part.length() > 1 && part.charAt(0) == '0') {
                return;
            }
            //Attaching part
            sb.append(part);
            //This is the logic
            //where you do not append dot in last part
            if (i + 1 == s.length()) {
                helper(sb, s, count, i + 1, list);
            } else {
                sb.append(".");
                helper(sb, s, count + 1, i + 1, list);
            }
            //Removing part
            sb.setLength(prevLen);
        }
    }

    public static void main(String[] args) {
        String s = "0000";
        System.out.println(restoreIpAddresses(s));

    }
}
