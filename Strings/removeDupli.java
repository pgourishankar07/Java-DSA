public class removeDupli {
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
        System.out.println(removeDuplicateLetters("buntyrupali"));
    }
}
