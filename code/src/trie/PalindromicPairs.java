package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicPairs {
    // https://fizzbuzzed.com/top-interview-questions-5/

    private class TrieNode {
        //index of the word in the words array (one int is enough as the words are
        //unique in the array)
        int wordsIndex = -1;
        //connecting Trie nodes by next letter ('a' = 0, 'b' = 1, ..., 'z' = 25)
        TrieNode[] nextLetter = new TrieNode[26];
        //list of indexes to words in the words array which has a suffix
        //finishing on this trie node and the rest of the word is palindrome
        //on its own
        List<Integer> palindromes = new ArrayList<>();
    }

    private boolean isPalindrome(String word, int headIndex, int tailIndex) {
        while (headIndex < tailIndex) {
            if (word.charAt(headIndex++) != word.charAt(tailIndex--)) {
                return false;
            }
        }
        return true;
    }

    private void addWordToTrie(TrieNode trieNode, String[] words, int wordIndex) {
        final String word = words[wordIndex];

        //we build the trie BACKWARDS (during pairing we look for a matching front)
        //and the center part of the pair to be palindrome on its own
        for (int i = word.length() - 1; i >= 0; i--) {
            //check if we have palindrome to add to the palindromes list of the trie node

            //note: words which are palindrome on the words list will go under the
            //palindrome list of the root trie node -> this will be very useful if
            //the word list contains "" (empty string) since that will be matched with
            //all these immediately palindrome strings.

            if (isPalindrome(word, 0, i)) {
                trieNode.palindromes.add(wordIndex);
            }

            //move one letter further

            final int letterIndex = word.charAt(i) - 'a';
            if (trieNode.nextLetter[letterIndex] == null) {
                trieNode.nextLetter[letterIndex] = new TrieNode();
            }
            trieNode = trieNode.nextLetter[letterIndex];
        }

        //we processed the whole word, we are at its last character
        //note: any single character word is palindrome so we add it
        //to the palindromes list
        //note: to be able to avoid pairing words with themselves
        //we mark this trie node with the index of the word (in the words array)
        trieNode.wordsIndex = wordIndex;
        trieNode.palindromes.add(wordIndex);
    }

    /**
     * Check if part of the given word is palindrome.
     *
     * @param word      The word to check.
     * @param headIndex The head index from which to check for being palindrome.
     * @param tailIndex The tail index from which to check for being palindrome.
     * @return true iff the word fragment is palindrome.
     */

    private void getPalindromePairs(List<List<Integer>> result, TrieNode trieNode, String[] words, int wordIndex) {
        final String word = words[wordIndex];

        for (int i = 0; i < word.length(); i++) {

            //check if the current trie node contains a full word (wordsIndex != -1)
            //note: avoid pairing words with themselves, hence check if the trie node
            //represents the same word we are searching palindrome pairs for (trieNode.wordsIndex != wordIndex)
            //and see if the substring remaining from word is palindrome -> if so
            //then we can pair our word with the word from the trie node
            if (trieNode.wordsIndex != -1 && trieNode.wordsIndex != wordIndex && isPalindrome(word, i, word.length() - 1)) {
                result.add(Arrays.asList(wordIndex, trieNode.wordsIndex));
            }

            //move to the next letter (if there is a path in the trie with the letter)
            final TrieNode nextLetterNode = trieNode.nextLetter[word.charAt(i) - 'a'];
            if (nextLetterNode == null) {
                return;
            }
            trieNode = nextLetterNode;
        }

        //we processed the whole word, we are at its last character
        //here we add all palindromes to the result list from this trie node
        for (final Integer palindromeWordIndex : trieNode.palindromes) {
            //avoid false pairs (e.g. with "aa", we would end up at the same trie node for the same word)
            //because it is the same as itself if reversed
            if (wordIndex == palindromeWordIndex) {
                continue;
            }
            result.add(Arrays.asList(wordIndex, palindromeWordIndex));
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        final TrieNode trieRoot = new TrieNode();

        //build trie for words
        for (int i = 0; i < words.length; i++) {
            addWordToTrie(trieRoot, words, i);
        }

        //build pairs
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            getPalindromePairs(result, trieRoot, words, i);
        }
        return result;
    }

}
