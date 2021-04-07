package bfs;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> dict = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();

        for (String s : wordList) {
            dict.put(s, new ArrayList<>());
            visited.put(s, false);
        }
        dict.put(beginWord, new ArrayList<>());
        visited.put(beginWord, false);
        for (Map.Entry<String, List<String>> e : dict.entrySet()) {
            findNeighbor(e.getKey(), dict);
        }
        System.out.println(dict);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.put(beginWord, true);
        int count = 0;
        boolean flag = false;
        while (!q.isEmpty() && !flag) {
            count++;

            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s1 = q.poll();
                if (s1.equals(endWord)) {
                    flag = true;
                    break;
                }
                List<String> temp = dict.get(s1);
                for (String s : temp) {
                    if (visited.get(s)) {
                        continue;
                    }
                    q.offer(s);
                    visited.put(s, true);
                }
            }
        }
        return (flag == true) ? count : 0;
    }

    public static void findNeighbor(String beginWord, Map<String, List<String>> dict) {

        for (int i = 0; i < beginWord.length(); i++) {
            char input[] = beginWord.toCharArray();
            char t1 = input[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == t1) {
                    continue;
                }
                input[i] = c;
                StringBuilder sb = new StringBuilder();
                for (char t : input) {
                    sb.append(t);
                }

                if (dict.containsKey(sb.toString())) {
                    dict.get(beginWord).add(new String(sb.toString()));
                }
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"hot", "dot", "dog", "lot", "log"};
        List<String> wordList = new ArrayList<>();
        for (String w : words) {
            wordList.add(w);
        }
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
