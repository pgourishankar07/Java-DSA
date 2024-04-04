//Find shortest Unique Prefix for every word (Assume no word is prefix of another)
public class PrefixPrblm {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;
        int freq;

        TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static TrieNode root = new TrieNode();

    public static void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.end = true;
    }

    public static void findPrefix(TrieNode root, String key) {
        if (root == null) {
            return;
        }

        if (root.freq == 1) {
            System.out.println(key);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], key + (char) (i + 'a'));
            }
        }
    }

    public static void main(String args[]) {
        String[] words = { "zebra", "dog", "duck", "dove" };

        for (String i : words) {
            insert(i);
        }

        root.freq = -1;

        findPrefix(root, "");

    }
}
