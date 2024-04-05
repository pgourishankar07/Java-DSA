// count no. of distinct rows in a Binary Matrix
public class Distinctrows {
    static class TrieNode {
        TrieNode children[] = new TrieNode[2];
        boolean end = false;

        TrieNode() {
            for (int i = 0; i < 2; i++) {
                children[i] = null;
            }
        }
    }

    public static TrieNode root = new TrieNode();

    public static void insert(int[] row) {
        TrieNode curr = root;

        for (int i : row) {
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }

        curr.end = true;
    }

    public static void prinAll(TrieNode root, String temp) {
        if (root.end) {
            System.out.println(temp);
        }

        for (int i = 0; i < 2; i++) {
            if (root.children[i] != null) {
                prinAll(root.children[i], temp + Integer.toString(i));
            }
        }
    }

    public static void main(String args[]) {

        int[][] matrix = {
                { 1, 0, 0 },
                { 0, 1, 1 },
                { 1, 0, 0 },
                { 1, 1, 1, }
        };

        for (int[] i : matrix) {
            insert(i);
        }

        prinAll(root, "");
    }
}
