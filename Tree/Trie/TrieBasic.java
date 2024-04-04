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

    public static void insert(String word) { // Time : O(L) -- Length of the Largest word
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode(); // if not exist create new Node to insert elements
            }

            curr = curr.children[idx]; // similar to temp = temp.next;
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

    public static void main(String args[]) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };

        for (String i : words) {
            insert(i);
        }
        // print();
        System.out.println(search("theeep"));
        System.out.println(search("thee"));
        System.out.println(wordBreak("theatherei"));
    }
}
