package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {
    public static int numUniqueEmails(String[] emails) {
        char[] email = emails[0].toCharArray();
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = 0; i < email.length; i++) {
            if (email[i] == '@') {
                break;
            }
            if (email[i] == '+') {
                while (i < email.length && email[i] != '.') {
                    System.out.println(email[i] + " " + i);
                    i++;
                }
            }
            if (email[i] == '.' && i < email.length) {
                i++;
                if (sb.lastIndexOf("@") > -1) {
                    sb.append(email[i]);
                }
            }
            sb.append(email[i]);
        }
        while (i < email.length) {
            sb.append(email[i]);
            i++;
        }
        set.add(sb.toString());
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.co"};
        System.out.println(numUniqueEmails(emails));
    }
}
