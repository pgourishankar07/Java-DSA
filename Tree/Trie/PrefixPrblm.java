//Find shortest Unique Prefix for every word (Assume no word is prefix of another)
public class PrefixPrblm {

    static class TrieNodeF {
        TrieNodeF[] children = new TrieNodeF[26];
        boolean end = false;
        int freq;

        TrieNodeF() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static TrieNodeF root = new TrieNodeF();

    public static void insert(String word) {

        TrieNodeF curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNodeF();
            } else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }

        curr.end = true;
    }

    public static void findPrefix(TrieNodeF root, String key) {
        if (root == null) {
            return;
        }

        if (root.freq == 1) {
            System.out.println(key);
            return;
        }

        for (int i = 0; i < 26; i++) { // 1. check words starting from which node go until reaching freq = 1
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

        root.freq = -1; // so that it should not stop by reaching node itself which has freq = 1 as
                        // default

        findPrefix(root, "");

    }
}
