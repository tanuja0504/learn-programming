package dynamicProgramming.DPGrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));
        if (triangle.size() > 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(dp.get(0).get(0) + triangle.get(1).get(0));
            temp.add(dp.get(0).get(0) + triangle.get(1).get(1));
            dp.add(temp);
        }

        for (int i = 2; i < triangle.size(); i++) {
            int sizeOfList = triangle.get(i).size();
            List<Integer> temp = new ArrayList<>();
            temp.add(dp.get(i - 1).get(0) + triangle.get(i).get(0));
            for (int j = 1; j < sizeOfList - 1; j++) {
                temp.add(Math.min(dp.get(i - 1).get(j - 1) + triangle.get(i).get(j),
                        dp.get(i - 1).get(j) + triangle.get(i).get(j)));
            }
            temp.add(dp.get(i - 1).get(sizeOfList - 2) + triangle.get(i).get(sizeOfList - 1));
            dp.add(temp);
        }

        int result = Integer.MAX_VALUE;
        for (int i : dp.get(dp.size() - 1)) {
            result = Math.min(result, i);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(minimumTotal(triangle));
    }
}
