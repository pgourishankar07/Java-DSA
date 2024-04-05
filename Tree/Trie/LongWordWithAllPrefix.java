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

        for (int i = 0; i < 26; i++) {
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

    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "ap", "apple", "apply", "appl" };

        for (String i : words) {
            insert(i);
        }

        LongWord(root, "");

        System.out.println(res);
    }
}
