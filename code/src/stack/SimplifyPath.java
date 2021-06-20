package stack;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        if (path.matches("/")) {
            return "/";
        }
        StringBuilder str = new StringBuilder("");
        Stack st = new Stack<>();
        String paths[] = path.split("/");

        for (int token = 0; token < paths.length; token++) {
            if (paths[token].equals("/") || paths[token].equals("")) {
                continue;
            } else if (paths[token].equals("..") && !st.isEmpty()) {
                st.pop();
            } else if (paths[token].equals("..") && st.isEmpty()) {
                st.push("/");
            } else if (paths[token].equals(".")) {
            } else {
                st.push(paths[token]);
            }
        }
        Stack rst = new Stack<>();
        while (!st.isEmpty()) {

            rst.push(st.pop());
        }
        while (!rst.isEmpty()) {
            if (rst.peek() != "/") {
                str.append("/");
            }
            str.append(rst.pop());
        }
        String op = str.toString().replace("//", "/");
        if (op.equals("")) {
            op = op + "/";
        }
        return op;
    }

    public static String simplifyPath1(String path) {

        String input[] = path.split("/");
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("/") || input[i].equals(".") || input[i].equals("")) {
                continue;
            } else if (input[i].equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(input[i]);
            }
        }

        if (st.isEmpty()) {
            sb.append("/");
        }

        while (!st.isEmpty()) {

            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(str));
        System.out.println(simplifyPath1(str));
    }
}
