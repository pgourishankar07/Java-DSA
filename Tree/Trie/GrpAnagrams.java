import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrpAnagrams {

    static class TrieNode {
        List<String> data;
        TrieNode[] children = new TrieNode[26];
        boolean end;

        TrieNode() {
            data = new ArrayList<>();
            Arrays.fill(children, null);
            end = false;
        }
    }

    private TrieNode root = new TrieNode();;
    private List<List<String>> res = new ArrayList<>();

    private void insert(String word) {
        TrieNode curr = root;
        char[] charArr = word.toCharArray();
        Arrays.sort(charArr); // Sorting characters to group anagrams

        for (char c : charArr) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }

        curr.end = true;
        curr.data.add(word); // Add original word to the Trie node
    }

    private void groupAnagramsHelper(TrieNode root) {
        if (root.end) {
            res.add(new ArrayList<>(root.data)); // Add the group of anagrams
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                groupAnagramsHelper(root.children[i]);
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        root = new TrieNode();
        res = new ArrayList<>();

        for (String str : strs) {
            insert(str);
        }

        groupAnagramsHelper(root);

        return res;
    }
}

/*
 * 1.create another attribute List<String> to store word
 * 2.while inserting sort the chars in the word and insert in Trie and add the
 * word to the list
 * 3.then traverse Trie and add the list of node when reaching end
 */