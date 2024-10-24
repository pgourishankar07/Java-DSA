import java.util.Arrays;

public class StringPrblms {

    // _______________//_______________//______________________
    // combination

    public static void printCombi(String str, String permu) {
        if (str.length() == 0) {
            System.out.println(permu);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printCombi(newStr, permu + str.charAt(i));
        }

    }

    // _______________//_______________//______________________

    public static void subSeq(String str, int i, String currStr) {

        if (i == str.length()) {
            System.out.println(currStr);
            return;
        }

        subSeq(str, i + 1, currStr + str.charAt(i));
        subSeq(str, i + 1, currStr);

    }

    // _______________//_______________//______________________
    // LCS (Longest Common Subsequences)

    public static int lcs(String str1, String str2, int i1, int i2, int[][] dp) {

        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        int notMatch = Math.max(lcs(str1, str2, i1 - 1, i2, dp), lcs(str1, str2, i1, i2 - 1, dp));
        int match = 0;

        if (str1.charAt(i1) == str2.charAt(i2)) {
            match = 1 + lcs(str1, str2, i1 - 1, i2 - 1, dp);
        }

        return dp[i1][i2] = Math.max(match, notMatch);
    }

    public static int lcsTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int i1 = 1; i1 <= n; i1++) {
            for (int i2 = 1; i2 <= m; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
            }
        }

        return dp[n][m];
    }

    public static String lcs1(String str1, String str2, int i1, int i2, String[][] dp) {
        if (i1 < 0 || i2 < 0) {
            return "";
        }

        if (dp[i1][i2] != null) {
            return dp[i1][i2];
        }

        if (str1.charAt(i1) == str2.charAt(i2)) {
            return dp[i1][i2] = lcs1(str1, str2, i1 - 1, i2 - 1, dp) + str1.charAt(i1);
        }

        String option1 = lcs1(str1, str2, i1 - 1, i2, dp); // Move `i1` back
        String option2 = lcs1(str1, str2, i1, i2 - 1, dp); // Move `i2` back

        return dp[i1][i2] = option1.length() > option2.length() ? option1 : option2;
    }

    // _______________//_______________//______________________
    // LCS (Longest Common Substring)

    public static int lcsub(String str1, String str2, int i1, int i2, int count) {
        if (i1 < 0 || i2 < 0) {
            return count;
        }

        int match = count;

        // If characters match, increase the count
        if (str1.charAt(i1) == str2.charAt(i2)) {
            match = lcsub(str1, str2, i1 - 1, i2 - 1, count + 1);
        }

        // If characters don't match, reset the count and check other options
        int notMatch = Math.max(lcsub(str1, str2, i1 - 1, i2, 0), lcsub(str1, str2, i1, i2 - 1, 0));

        // Return the maximum of match and notMatch
        return Math.max(match, notMatch);
    }

    public static int lcstr(String s1, String s2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    int val = 1 + dp[i - 1][j - 1]; // checking the previous element is matchs or not
                    dp[i][j] = val;

                    ans = Math.max(ans, val);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    // _______________//_______________//______________________
    // LPS (Longest Palindromic Subseq)

    // Approach : lcs(str,reverse(str))

    // _______________//_______________//______________________
    // Min. operations to make String palindrome

    // Approach : str.length() - Longest Palindromic Subsequence

    // _______________//_______________//______________________
    // Minimum Insertions/Deletions to Convert String1 to String2

    // Approach :
    // no. of insertion : str2.len() - lcs and no. of deletion : str1.len()-lcs

    // _______________//_______________//______________________
    // Shortest common Superseq

    // largest common super sequence of two strings is : str1 + str2 (concat them)

    // for finding only the length of the shortest super seq. is :
    // str1.len() + str2.len() - lcs

    public static String shortSuprSub(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int i1 = 1; i1 <= n; i1++) {
            for (int i2 = 1; i2 <= m; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = 0 + Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
            }
        }

        int i = n;
        int j = m;

        String ans = ""; // this part os for getting the string

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans += s1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += s1.charAt(i - 1);
                i--;
            } else {
                ans += s2.charAt(j - 1);
                j--;
            }
        }

        while (i > 0) {
            ans += s1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            ans += s2.charAt(j - 1);
            j--;
        }

        String ans2 = new StringBuilder(ans).reverse().toString();

        return ans2;
    }

    // _______________//_______________//______________________
    // Count Distinct Subsequence(how many times the str2 appears in str1) -- just
    // same as lcs but here u need ti add not find max

    public static int countLcs(String str1, String str2, int i, int j, int[][] memo) {

        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];

        if (str1.charAt(i) == str2.charAt(j)) { // if matched move the ptrs simultaneously and check for another
                                                // ocuurence of this same
            memo[i][j] = countLcs(str1, str2, i - 1, j - 1, memo) + countLcs(str1, str2, i - 1, j, memo);
        } else {
            memo[i][j] = countLcs(str1, str2, i - 1, j, memo);
        }

        return memo[i][j];
    }

    public static int countLcsTab(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n1][n2];
    }

    // _______________//_______________//______________________
    // edit distance - min. no. of operations to make the string same as another
    // string (insert+delete+replace)

    public static int editDist(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = editDist(s1, s2, i - 1, j - 1, dp);
        } else {
            int insert = 1 + editDist(s1, s2, i - 1, j, dp);
            int delete = 1 + editDist(s1, s2, i, j - 1, dp);
            int replace = 1 + editDist(s1, s2, i - 1, j - 1, dp);

            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j];
    }

    // _______________//_______________//______________________
    // Wild Card Matching

    public boolean match(String s1, String s2, int i, int j, Boolean[][] dp) {
        if (i < 0 && j < 0) {
            return true;
        }

        if (j < 0) {
            for (int k = 0; k <= i; k++) {
                if (s1.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (i < 0) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i) == '?' || s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = match(s1, s2, i - 1, j - 1, dp);
        }

        if (s1.charAt(i) == '*') {
            return dp[i][j] = match(s1, s2, i - 1, j, dp) || match(s1, s2, i, j - 1, dp);
        }

        return dp[i][j] = false;

    }

    public static void main(String args[]) {

        // printCombi("abc", "");
        // System.out.println();
        // subSeq("abc", 0, "");

        // _______________//_______________//______________________

        // String text1 = "adebc";
        // String text2 = "dcadb";

        // int n1 = text1.length();
        // int n2 = text2.length();

        // int[][] dp = new int[n1 + 1][n2 + 1];
        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }

        // System.out.println(lcs(text1, text2, n1 - 1, n2 - 1, dp));

        // _______________//_______________//______________________

        String text1 = "abaaa"; // adebc
        String text2 = "baabaca"; // dcadb

        int n1 = text1.length();
        int n2 = text2.length();

        String[][] dp = new String[n1 + 1][n2 + 1];

        System.out.println(lcs1(text1, text2, n1 - 1, n2 - 1, dp));
        // _______________//_______________//______________________

        // String text1 = "abcjklp";
        // String text2 = "acjkp";

        // int n1 = text1.length();
        // int n2 = text2.length();

        // System.out.println(lcstr(text1, text2, n1, n2));
        // _______________//_______________//______________________

        // String text1 = "bbbab";
        // StringBuilder str2 = new StringBuilder(text1);
        // String text2 = str2.reverse().toString();

        // int n1 = text1.length();

        // int[][] dp = new int[n1][n1];
        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }

        // System.out.println(lcs(text1, text2, n1 - 1, n1 - 1, dp));

        // _______________//_______________//______________________

        // String str1 = "brute";
        // String str2 = "groot";

        // System.out.println(shortSuprSub(str1, str2));

        // _______________//_______________//______________________

        // String text1 = "babgbag";
        // String text2 = "bag";

        // int n1 = text1.length();
        // int n2 = text2.length();

        // int[][] dp = new int[n1 + 1][n2 + 1];
        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }

        // System.out.println(countLcs(text1, text2, n1 - 1, n2 - 1, dp));
        // System.out.println(countLcsTab(text1, text2));

        // _______________//_______________//______________________
        // String s1 = "horse";
        // String s2 = "ros";
        // int n = s1.length();
        // int m = s2.length();

        // int[][] dp = new int[n][m];
        // for (int row[] : dp)
        // Arrays.fill(row, -1);

        // System.out.println(editDist(s1, s2, n - 1, m - 1, dp));

    }
}
