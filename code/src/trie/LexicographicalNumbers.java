package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Trie1 {
    static int N = 10;

    public static class TrieNode {
        TrieNode children[] = new TrieNode[N];
        int val;
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < N; i++) {
                children[i] = null;
            }
        }
    }

    public static TrieNode root;

    public Trie1() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(int data) {
        List<Integer> input = digits(data);
        TrieNode curr = root;
        for (int i = 0; i < input.size(); i++) {
            int c = input.get(i);
            if (curr.children[c] == null) {
                curr.children[c] = new TrieNode();
            }
            curr = curr.children[c];
        }
        curr.val = data;
        curr.isEndOfWord = true;
    }

    public List<Integer> digits(int d) {
        List<Integer> list = new ArrayList<>();
        while (d > 0) {
            list.add(d % 10);
            d = d / 10;
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> dfs(TrieNode node, List<Integer> result) {
        if (root == null) {
            return result;
        }
        if (node.val != 0) {
            result.add(node.val);
        }
        for (int i = 0; i < N; i++) {
            if (node.children[i] != null) {
                dfs(node.children[i], result);
            }
        }
        return result;
    }

}

public class LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        Trie1 t = new Trie1();
        for (int i = 1; i <= n; i++) {
            t.insert(i);
        }
        List<Integer> result = new ArrayList<>();
        return t.dfs(t.getRoot(), result);
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }
}
