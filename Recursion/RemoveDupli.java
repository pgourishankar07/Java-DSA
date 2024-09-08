import java.util.Arrays;

public class RemoveDupli {

    public static StringBuilder RemoveDuplicates(String str, int i, StringBuilder strB, boolean[] map) {

        if (i == str.length()) {
            return strB;
        }
        if (map[str.charAt(i) - 'a'] != true) {
            strB.append(str.charAt(i));
        }

        map[str.charAt(i) - 'a'] = true;

        return RemoveDuplicates(str, i + 1, strB, map);
    }

    public static String removeDuplicateLetters(String s) {// Lexographical Order

        char arr[] = new char[26];

        int n = s.length();

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] = s.charAt(i);
        }

        StringBuilder strB = new StringBuilder("");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                strB.append(arr[i]);
            }
            // System.out.println(arr[i]);
        }

        return strB.toString();

    }

    public static void main(String args[]) {
        String str = "apnacollege";
        StringBuilder strB = new StringBuilder();
        boolean[] map = new boolean[26];
        System.out.println(RemoveDuplicates(str, 0, strB, map));
        System.out.println(removeDuplicateLetters(str));
    }
}
