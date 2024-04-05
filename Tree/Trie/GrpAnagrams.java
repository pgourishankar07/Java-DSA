import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrpAnagrams {
    static class TrieNode {
        List<String> data;
        TrieNode children[] = new TrieNode[26];
        boolean end;

        TrieNode() {
            data = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            end = false;
        }
    }

    public static TrieNode root = new TrieNode();
    public static List<List<String>> res = new ArrayList<>();

    public static void insert(String word) {
        TrieNode curr = root;

        char[] charArr = word.toCharArray();
        Arrays.sort(charArr);

        for (char c : charArr) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.end = true;
        curr.data.add(word);
    }

    public static void grpAnag(TrieNode root) {
        if (root.end) {
            res.add(root.data);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                grpAnag(root.children[i]);
            }
        }
    }

    public static void main(String args[]) {
        String words[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        for (String i : words) {
            insert(i);
        }

        grpAnag(root);

        System.out.println(res);

        /*
         * 1.create another attribute List<String> to store word
         * 2.while inserting sort the chars in the word and insert in Trie and add the
         * word to the list
         * 3.then traverse Trie and add the list of node when reaching end
         */
    }
}
