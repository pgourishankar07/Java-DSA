public class keypad {
    public static String[] keypads = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void keyCombi(String str, int i, String res) {
        if (i == str.length()) {
            System.out.println(res);
            return;
        }

        String map = keypads[str.charAt(i) - '0'];
        for (int j = 0; j < map.length(); j++) {
            keyCombi(str, i + 1, res + map.charAt(j));
        }
    }

    public static void main(String args[]) {
        keyCombi("23", 0, "");
    }
}
