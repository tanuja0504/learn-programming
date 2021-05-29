package bfs;

import java.util.*;

public class WordLadder3 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        Map<String, List<String>> dictionary = new HashMap<>();
        System.out.println(wordList.contains(beginWord));
        dictionary.put(beginWord, new ArrayList<>());
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        for (String s : wordList) {
            dictionary.put(s, new ArrayList<>());
        }
        for (Map.Entry<String, List<String>> e : dictionary.entrySet()) {
            getNeighbors(e.getKey(), wordList, dictionary);
        }
        int minDepth = getMinDepthBFS(beginWord, endWord, dictionary);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        getMinPathDFS(result, list, beginWord, endWord, minDepth, dictionary, new HashSet<>());
        return result;
    }

    public static void getNeighbors(String beginWord, List<String> wordList, Map<String, List<String>> dictionary) {

        for (int i = 0; i < beginWord.length(); i++) {
            char input[] = beginWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                input[i] = c;
                StringBuilder sb = new StringBuilder();
                for (char t : input) {
                    sb.append(t);
                }
                if (wordList.contains(sb.toString()) && !sb.toString().equals(beginWord)) {
                    dictionary.get(beginWord).add(sb.toString());
                }
            }
        }
    }

    public static int getMinDepthBFS(String beginWord, String endWord, Map<String, List<String>> dictionary) {
        if (beginWord == endWord) {
            return 0;
        }
        int depth = 0;
        Queue<String> depthQ = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        depthQ.add(beginWord);
        while (!depthQ.isEmpty()) {
            if (beginWord == endWord) {
                break;
            }
            int size = depthQ.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String s = depthQ.poll();
                if (!visited.contains(s)) {
                    List<String> neighbors = dictionary.get(s);
                    for (String t : neighbors) {
                        if (!visited.contains(t)) {
                            depthQ.add(t);
                        }
                    }
                }
                visited.add(s);
            }
        }
        return depth;
    }

    public static void getMinPathDFS(List<List<String>> result, List<String> list, String beginWord, String endWord, int minDepth, Map<String, List<String>> dictionary, Set<String> visited) {

        if (list.size() > minDepth && !beginWord.equals(endWord)) {
            return;
        }

        if (list.size() <= minDepth && beginWord.equals(endWord)) {
            result.add(new ArrayList<>(list));
            return;
        }
        List<String> neighbors = dictionary.get(beginWord);
        for (String s : neighbors) {
            if (visited.contains(s)) {
                continue;
            }
            visited.add(s);
            list.add(s);
            getMinPathDFS(result, list, s, endWord, minDepth, dictionary, visited);
            int size = list.size() - 1;
            list.remove(size);
            visited.remove(s);
        }
    }

    public static void main(String[] args) {
        String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
        String beginWord = "hit";
        String endWord = "cog";
        String words1[] = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        String beginWord1 = "qa";
        String endWord1 = "sq";
        List<String> wordList = new ArrayList<>();
        for (String w : words) {
            wordList.add(w);
        }
        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}
