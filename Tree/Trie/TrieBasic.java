public class TrieBasic {

    static class TrieNode {
        TrieNode children[] = new TrieNode[26];
        boolean end = false; // for marking the words last char as end

        TrieNode() {
            for (int i = 0; i < 26; i++) { // 26 - using only alphabets
                children[i] = null;
            }
        }
    }

    public static TrieNode root = new TrieNode();

    // insert words in the Trie
    public static void insert(String word) { // Time : O(L) -- Length of the Largest word
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode(); // if not exist create new Node to insert elements
            }

            curr = curr.children[idx]; // similar to temp = temp.next (going next level)
        }

        curr.end = true;
    }

    // search a word in the Trie
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

    // count number of nodes or chars in the Trie
    public static int countNodes(TrieNode root, int[] count) {

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count[0] = 1 + countNodes(root.children[i], count);
            }
        }
        return count[0];
    }

    // print all Words
    public static void printWords(TrieNode root, String prefix) {
        if (root == null) { // this is not required just wrote for practicing recursion
            return;
        }

        if (root.end) {
            System.out.println(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printWords(root.children[i], prefix + (char) ('a' + i));
            }
        }
    }

    // find whether the string key can be seperated into words that present in the
    // trie
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) { // finding all possible substrings and searching in Trie
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    // find is there any string like key is in prefix of any word
    public static boolean startsWith(String key) {
        TrieNode curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String args[]) {
        // String words[] = { "the", "a", "there", "their", "any", "thee" };
        String words[] = { "apple", "mango", "man", "woman", "app" };

        for (String i : words) {
            insert(i);
        }
        // print();
        System.out.println(search("theeep"));
        System.out.println(search("thee"));
        System.out.println(wordBreak("theatherei"));

        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));
        System.out.println(startsWith("man"));

        System.out.println();

        printWords(root, "");

        System.out.println();

        int[] c = { 0 };
        System.out.println(countNodes(root, c));
    }
}
