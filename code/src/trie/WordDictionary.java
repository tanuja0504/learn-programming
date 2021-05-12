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
        int len = word.length();
        TrieNode curr = new TrieNode();
        curr = root;
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public TrieNode searchWithDot(TrieNode node, String word) {
        System.out.println(word);
        if (node == null) {
            return node;
        }
        TrieNode curr = node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr != null && curr.children[index] != null) {
                curr = curr.children[index];
            } else {
                return null;
            }
        }
        return curr;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        int len = word.length();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                TrieNode result;
                for (char c = 'a'; c <= 'z'; c++) {
                    String word1 = word.substring(0, i) + c + word.substring(i + 1, len);
                    result = searchWithDot(curr, word1);
                    if (result == null) {
                        return false;
                    } else {
                        curr = result;
                    }
                }
            } else if (word.charAt(i) != '.' && curr != null) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] != null) {
                    curr = curr.children[index];
                } else {
                    return false;
                }
            }
        }
        return curr.isEndOfWord;
    }

    public static void main(String[] args) {
        String word = "bad";
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        obj.addWord("pad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("b.."));
    }
}
