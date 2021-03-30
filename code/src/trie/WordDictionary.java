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
        if (node == null) {
            return node;
        }
        TrieNode curr = node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] != null) {
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
                int j = 0;
                TrieNode result = null;
                while (j < root.N && result == null) {
                    result = searchWithDot(curr.children[j], word.substring(i + 1, len));
                    if (result != null) {
                        break;
                    }
                    j++;
                }
                if (result != null) {
                    curr = result;
                } else {
                    return false;
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
        String word = "apple";
        WordDictionary obj = new WordDictionary();
        obj.addWord(word);
        System.out.println(obj.search("app.."));
    }
}
