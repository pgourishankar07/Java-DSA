// Print the Longest word from the Dictionary(Trie) such that every prefix of that word is in Trie/words[] (in Lexicographically small order)

public class LongWordWithAllPrefix {

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

    public static String res = "";

    public static void LongWord(TrieNode root, String temp) {

        for (int i = 0; i < 26; i++) { // for Lexicographically large order, reverse the traverse
            if (root.children[i] != null && root.children[i].end) {
                temp = temp + (char) ('a' + i);

                if (temp.length() > res.length()) {
                    res = temp;
                }

                LongWord(root.children[i], temp);

                temp = temp.substring(0, temp.length() - 1);
            }
        }

    }

    /*
     * //Another method
     * public static String LongWord(TrieNode root, String temp, String res) {
     * 
     * for (int i = 0; i < 26; i++) {
     * if (root.children[i] != null && root.children[i].end) {
     * temp = temp + (char) ('a' + i);
     * 
     * if (temp.length() > res.length()) {
     * res = temp;
     * }
     * 
     * res = LongWord(root.children[i], temp, res);
     * 
     * temp = temp.substring(0, temp.length() - 1);
     * }
     * }
     * 
     * return res;
     * 
     * }
     */
    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "ap", "apple", "apply", "appl" };

        for (String i : words) {
            insert(i);
        }

        // System.out.println(LongWord(root, "", ""));

        LongWord(root, "");
        System.out.println(res);

        /*
         * 1. Traverse all the nodes
         * 2. append the char which has end = true;
         * 3. if the temp.len() > ans.len() then only store the ans = temp;
         * 4. Backtrack : remove the last char in temp, then it will append next char on
         * same level
         */
    }
}
