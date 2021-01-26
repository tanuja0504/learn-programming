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

    public static void main(String[] args) {
        String str = "/.";
        System.out.println(simplifyPath(str));
    }
}
