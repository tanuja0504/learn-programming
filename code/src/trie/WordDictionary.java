package trie;

public class WordDictionary {
    public static class TrieNode {
        int N = 26;
        TrieNode children[] = new TrieNode[N];
        boolean isEndOfWord = false;

        public TrieNode() {
            for (int i = 0; i < N; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return isAMatch(word.toCharArray(), 0, root);
    }

    public boolean isAMatch(char input[], int start, TrieNode node) {

        if (start == input.length) {
            return node.isEndOfWord;
        }
        boolean result = false;
        if (input[start] != '.') {
            result = node.children[input[start] - 'a'] != null && isAMatch(input, start + 1, node.children[input[start] - 'a']);
        } else {
            for (char c = 0; c < 26; c++) {
                if (node.children[c] != null) {
                    result = isAMatch(input, start + 1, node.children[input[start + 1] - 'a']);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String word = "bad";
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        obj.addWord("pad");
        //System.out.println(obj.search("pad"));
        System.out.println(obj.search("x.."));
    }
}
