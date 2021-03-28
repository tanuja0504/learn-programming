package misc;

import java.util.ArrayList;
import java.util.List;

public class test4 {
    public static List<String> doesCircleExist(List<String> commands) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < commands.size(); i++) {
            String temp = "NO";
            String command = commands.get(i);
            char input[] = command.toCharArray();
            int matrix[] = {0, 0};
            char direction = 'E';
            for (int j = 0; j < input.length; j++) {
                System.out.println(direction + " " + input[j]);
                if (input[j] == 'G' && direction == 'E') {
                    matrix[0]++;
                } else if (input[j] == 'G' && direction == 'W') {
                    matrix[0]--;
                } else if (input[j] == 'G' && direction == 'N') {
                    matrix[1]++;
                } else if (input[j] == 'G' && direction == 'S') {
                    matrix[1]--;
                }
                if (input[j] == 'R' && direction == 'E') {
                    direction = 'S';
                } else if (input[j] == 'R' && direction == 'W') {
                    direction = 'N';
                } else if (input[j] == 'R' && direction == 'N') {
                    direction = 'E';
                } else if (input[j] == 'R' && direction == 'S') {
                    direction = 'W';
                }
                if (input[j] == 'L' && direction == 'E') {
                    direction = 'N';
                } else if (input[j] == 'L' && direction == 'W') {
                    direction = 'S';
                } else if (input[j] == 'L' && direction == 'N') {
                    direction = 'W';
                } else if (input[j] == 'L' && direction == 'S') {
                    direction = 'E';
                }
            }
            if (matrix[0] == 0 && matrix[1] == 0) {
                temp = "YES";
            }
            System.out.println(matrix[0] + " " + matrix[1]);
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("RGL");
        //list.add("RG");
        System.out.println(doesCircleExist(list));
    }

}
