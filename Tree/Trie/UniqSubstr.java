// Unique substrings for a string key

public class UniqSubstr {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;

        TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static TrieNode root = new TrieNode();

    public static void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.end = true;
    }

    // count number of nodes or chars in the Trie
    public static int countNodes(TrieNode root, int[] count) {

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count[0] = 1 + countNodes(root.children[i], count);
            }
        }
        return count[0];
    }

    // by apna College
    public static int countN(TrieNode root) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count = count + countN(root.children[i]);
            }
        }
        return count + 1;
    }

    // to print all Unique Substr for the word (Trie stores unique prefixes)
    public static void printUniqSubstr(TrieNode root, String word) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                System.out.println(word + (char) ('a' + i));
                printUniqSubstr(root.children[i], word + (char) ('a' + i));
            }
        }
    }

    public static void main(String args[]) {

        String str = "ababa";

        for (int i = 0; i < str.length(); i++) { // 1. inserting all suffix of the word
            insert(str.substring(i));
        }

        // int[] c = { 0 };
        // System.out.println(countNodes(root, c)); // 2. count no. of nodes in Trie
        // (bcoz each node is unique prefix)

        System.out.println(countN(root)); // actually the number of nodes is 9 but we are adding another 1 for " "
        printUniqSubstr(root, "");

    }
}
