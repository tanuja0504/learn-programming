package string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagString {
    public static String convert(String s, int numRows) {
        String output = "";
        char input[] = s.toCharArray();
        int inputLen = input.length;
        List<Character> o = new ArrayList<>();
        int row = numRows;
        int col = 2 * ((inputLen / numRows)) + 1 - 2;
        char result[][] = new char[row][col];
        int r = 0, c = 0;
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = ' ';
            }
        }
        while (k < inputLen) {
            r = 0;
            while (r < row && k < inputLen) {
                //System.out.print("Col "+c%2+" ");
                if (c % 2 == 1) {
                    if (r == 0 || r == row - 1) {
                        result[r][c] = ' ';
                    } else {
                        //result[r][c]=input[k];
                        result[r][c] = 'c';
                        k++;
                    }
                } else {
                    result[r][c] = input[k];
                    k++;
                }
                r++;
            }
            c++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (result[i][j] != ' ') {
                    o.add(result[i][j]);
                }
            }
            System.out.println();
        }
        output = o.toString();
        return output;
    }

    public static String convertq(String s, int numRows) {
        String output = "";
        char input[] = s.toCharArray();
        int inputLen = input.length;
        List<Character>[] list = new ArrayList[inputLen / (numRows - 2)];
        boolean inputMark[] = new boolean[inputLen];

        int slow = 0, fast = 0, revFast = 0;
        while (slow < inputLen) {
            fast = slow;
            revFast = slow + numRows + numRows - 2;
            slow++;
            while (fast < inputLen && !inputMark[fast]) {
                //list.add(input[fast]);
                inputMark[fast] = true;
                fast = fast + numRows + numRows - 2;
            }

        }
        output = list.toString();
        for (boolean a : inputMark) {
            System.out.print(a + " ");
        }
        return output;
    }

    public static String convertI(String s, int numRows) {
        if (s.length() < numRows) {
            return s;
        }
        StringBuilder output = new StringBuilder();
        char input[] = s.toCharArray();
        int inputLen = input.length;
        List<Character> o = new ArrayList<>();
        int row = numRows;
        int col = 2 * ((inputLen / numRows)) + 1 - 2;
        int result[][] = new int[row][col];

        int r = 0, c = 0, k = 0;
        for (r = 0; r < row; r++) {
            for (c = 0; c < col; c++) {
                result[r][c] = -1;
            }
        }
        for (c = 0; c < col; c++) {
            if (c % 2 == 0) {
                r = 0;
                while (r < row && k < inputLen) {
                    result[r][c] = k;
                    r++;
                    k++;
                }
            }
            if (c % 2 == 1) {
                r = row - 1;
                while (r >= 0 && k < inputLen) {
                    if (r > 2 && (r == 0 || r == row - 1)) {
                        result[r][c] = -1;
                        r--;
                    } else if (r <= 2 && (r == row - 1)) {
                        result[r][c] = -1;
                        r--;
                    } else {
                        result[r][c] = k;
                        r--;
                        k++;
                    }
                }
            }
        }
        for (r = 0; r < row; r++) {
            for (c = 0; c < col; c++) {
                if (result[r][c] != -1) {
                    output.append(input[result[r][c]]);
                }
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertI("ABC", 2));
    }
}
