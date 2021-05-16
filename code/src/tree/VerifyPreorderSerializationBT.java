package tree;

import java.util.Stack;

public class VerifyPreorderSerializationBT {
    /*The key here is, when you see two consecutive "#" characters on stack, pop both of them and replace the topmost element on the stack with "#". For example,

    preorder = 1,2,3,#,#,#,#

    Pass 1: stack = [1]

    Pass 2: stack = [1,2]

    Pass 3: stack = [1,2,3]

    Pass 4: stack = [1,2,3,#]

    Pass 5: stack = [1,2,3,#,#] -> two #s on top so pop them and replace top with #. -> stack = [1,2,#]

    Pass 6: stack = [1,2,#,#] -> two #s on top so pop them and replace top with #. -> stack = [1,#]

    Pass 7: stack = [1,#,#] -> two #s on top so pop them and replace top with #. -> stack = [#]

    If there is only one # on stack at the end of the string then return True else return False.
   */
    public static boolean isValidSerialization(String preorder) {
        Stack<String> st = new Stack();
        String input[] = preorder.split(",");
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("#")) {
                while (!st.isEmpty() && st.peek().equals("#")) {
                    st.pop();
                    if (!st.isEmpty()) {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
            st.push(input[i]);
        }
        return (st.size() == 1 && st.peek().equals("#")) ? true : false;
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String s1 = "9,#,#,1";
        String s2 = "#,#,#";
        String s3 = "9,#,92,#,#";
        System.out.println(isValidSerialization(s2));
    }
}
