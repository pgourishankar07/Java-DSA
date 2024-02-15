public class permuStr {

    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    public static void printPermutations(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
            return;
        }

        for (int i = start; i <= end; i++) {
            str = swap(str, start, i);
            printPermutations(str, start + 1, end);
            str = swap(str, start, i); // Backtrack to restore the original string
        }
    }

    // Another alternative method
    public static void printPermu(String str, String permu) {
        if (str.length() == 0) {
            System.out.println(permu);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPermu(newStr, permu + str.charAt(i));
        }

    }

    public static void main(String[] args) {
        String str = "abcd";
        // printPermutations(str, 0, str.length() - 1);
        printPermu(str, "");
    }
}
