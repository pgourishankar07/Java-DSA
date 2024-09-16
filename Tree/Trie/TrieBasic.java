public class TrieBasic {

    public static TrieNode root = new TrieNode();

    static class TrieNode {
        TrieNode children[] = new TrieNode[26];
        boolean end = false; // for marking the words last char as end
    }

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

    // search a word in the Trie and delete
    public static boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        boolean res = curr.end;
        // curr.end = false; // just mark it as false; to delete a word in Trie
        return res;
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

        for (int i = 1; i <= key.length(); i++) { // finding all possible substrings and searching in Trie 1. search
                                                  // 2.then break
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

    // Largest Word in Trie
    public static String largWrd(TrieNode root, String temp, String res) {
        if (root.end) {
            if (temp.length() > res.length()) {
                res = temp;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                res = largWrd(root.children[i], temp + (char) ('a' + i), res);
            }
        }

        return res;
    }

    // word search
    public static void wrdSrch(String key) {
        TrieNode curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                break;
            }

            curr = curr.children[idx];
        }

        if (startsWith(key)) {
            printWords(curr, key);
        }

    }

    public static void main(String args[]) {
        // String words[] = { "the", "a", "there", "their", "any", "thee" };
        // String words[] = { "apple", "mangoose", "man", "woman", "app" };
        String words[] = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };

        for (String i : words) {
            insert(i);
        }
        // print();
        // System.out.println(search("theeep"));
        // System.out.println(search("thee"));
        System.out.println(wordBreak("mobilemousemonitor"));
        System.out.println();

        // System.out.println(startsWith("app"));
        // System.out.println(startsWith("moon"));
        // System.out.println(startsWith("man"));

        System.out.println();

        // printWords(root, "");

        // System.out.println();

        // int[] c = { 0 };
        // System.out.println(countNodes(root, c));

        // System.out.println();
        // System.out.println(largWrd(root, "", ""));
        // // System.out.println(res);

        // System.out.println("apple".substring(0, 0 + 1));

        wrdSrch("mo");
    }
}
