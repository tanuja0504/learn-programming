package backtracking;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, new StringBuilder(), word, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, StringBuilder target, String word, boolean[][] visited
            , int i, int j, int count) {
        System.out.println(target);
        if (count == word.length()) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(count)) {
            return false;
        }

        visited[i][j] = true;
        target.append(board[i][j]);
        boolean result =
                helper(board, target, word, visited, i + 1, j, count + 1) ||
                        helper(board, target, word, visited, i - 1, j, count + 1) ||
                        helper(board, target, word, visited, i, j + 1, count + 1) ||
                        helper(board, target, word, visited, i, j - 1, count + 1);
        visited[i][j] = false;
        target.deleteCharAt(target.length() - 1);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board1 = {{'A', 'B'}, {'C', 'D'}};
        char[][] board2 = {{'a', 'a', 'b', 'a', 'a', 'b'},
                {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a', 'b', 'a'},
                {'b', 'a', 'b', 'b', 'a', 'b'},
                {'a', 'b', 'b', 'a', 'b', 'a'},
                {'b', 'a', 'a', 'a', 'a', 'b'}};
        String word = "bbbaabbbbbab";
        System.out.println(exist(board2, word));
    }
}
