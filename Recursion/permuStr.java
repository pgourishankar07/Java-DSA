import java.util.ArrayList;

public class permuStr {

    // https://www.youtube.com/watch?v=f2ic2Rsc9pU

    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
        return sb.toString();
    }

    public static void printPermutations(String str, int start, int end, int[] count) { // n! -- no. of permutations
        if (start == end) {
            System.out.println(str);
            count[0]++;
            return;
        }

        for (int i = start; i <= end; i++) {
            str = swap(str, start, i);
            printPermutations(str, start + 1, end, count);// curr pos is swapped pass +1 for next position swaps
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
            // exclude curr char for next pass
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPermu(newStr, permu + str.charAt(i)); // include curr char in the res string
        }

    }

    public static void printPermuOptimized(String str, StringBuilder permu, boolean[] used) {
        if (permu.length() == str.length()) {
            System.out.println(permu.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                // Mark the character as used
                used[i] = true;
                permu.append(str.charAt(i));

                // Recurse with the current character included in the permutation
                printPermuOptimized(str, permu, used);

                // Backtrack: remove the character and mark it as unused
                permu.deleteCharAt(permu.length() - 1);
                used[i] = false;
            }
        }
    }

    // permutation of 0s and 1s
    public static void printPermu(int n, String str, ArrayList<String> arr) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        printPermu(n - 1, str + '1', arr);
        printPermu(n - 1, str + '0', arr);

    }

    // combination or subsequence
    public static void subSeq(String str, int i, String res) {

        if (i == str.length()) {
            System.out.println(res);
            return;
        }

        subSeq(str, i + 1, res); // exclude
        subSeq(str, i + 1, res + str.charAt(i)); // include

    }

    public static void main(String[] args) {
        String str = "abc";
        int[] count = { 0 };
        printPermutations(str, 0, str.length() - 1, count);
        System.out.println(count[0]);
        // printPermu(str, "");

        // ArrayList<String> arr = new ArrayList<>();

        // printPermu(3, "", arr);
    }
}
