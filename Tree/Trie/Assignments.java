import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Assignments {

    public static List<List<String>> res = new ArrayList<>();
    public static Set<String> groupedWords = new HashSet<>();
    public static TrieNode root = new TrieNode();

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;

        TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

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

    public static boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.end;
    }

    public static void permutation(String str, String permu, List<String> list) {
        if (str.length() == 0) {
            list.add(permu);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutation(newStr, permu + str.charAt(i), list);
        }

    }

    public static void grouping(String[] words) {

        for (String i : words) {
            if (!groupedWords.contains(i)) {
                List<String> list = new ArrayList<>();
                permutation(i, "", list);

                List<String> ans = new ArrayList<>();
                for (String j : list) {
                    if (search(j)) {
                        ans.add(j);
                        groupedWords.add(j);
                    }
                }
                res.add(ans);
            }
        }
    }

    public static void main(String args[]) {

        String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };

        for (String i : words) {
            insert(i);
        }

        grouping(words);

        System.out.println(res);

    }
}
