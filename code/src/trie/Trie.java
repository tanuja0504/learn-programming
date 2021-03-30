package trie;

public class Trie {
    static int N = 26;

    public static class TrieNode {
        TrieNode children[] = new TrieNode[N];
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < N; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int length = word.length();
        TrieNode curr = new TrieNode();
        curr = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) {
                curr.children[c] = new TrieNode();
            }
            curr = curr.children[c];
        }
        curr.isEndOfWord = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] != null) {
                curr = curr.children[c];
            } else {
                return false;
            }
        }
        return curr.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int length = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (curr.children[c] != null) {
                curr = curr.children[c];
                length++;
            } else {
                break;
            }
        }
        return (prefix.length() == length) ? true : false;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.startsWith("app"));
    }
}
