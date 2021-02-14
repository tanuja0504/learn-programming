package backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (String word : words) {
                    if (board[i][j] == word.charAt(0) && helper(board, visited, word, new StringBuilder(), 0, i, j)) {
                        if (!list.contains(word)) {
                            list.add(word);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean helper(char[][] board, boolean[][] visited, String word, StringBuilder target, int count, int i, int j) {
        if (count == word.length()) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(count)) {
            return false;
        }

        visited[i][j] = true;
        target.append(board[i][j]);
        boolean result =
                helper(board, visited, word, target, count + 1, i + 1, j) ||
                        helper(board, visited, word, target, count + 1, i - 1, j) ||
                        helper(board, visited, word, target, count + 1, i, j + 1) ||
                        helper(board, visited, word, target, count + 1, i, j - 1);
        visited[i][j] = false;
        target.deleteCharAt(target.length() - 1);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}};
        char[][] board1 = {{'A', 'B'}, {'C', 'D'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }
}
