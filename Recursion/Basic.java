import java.util.HashSet;
import java.util.Scanner;

public class Basic {

    // print n numbers in decending order
    public static void decOrder(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        decOrder(n - 1);
    }

    // print n numbers in ascending order
    public static void incOrder(int n) {
        if (n == 0) {
            return;
        }
        incOrder(n - 1);
        System.out.println(n);
    }

    // factorial of a number
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    // sum of n numbers
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    // fibonacci of nth number
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // check array is sorted or not
    public static boolean srted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return srted(arr, i + 1);
    }

    // find an element in an array
    public static void find(int[] arr, int i, int key) {

        if (i == arr.length - 1) {
            return;
        }

        if (arr[i] == key) {
            System.out.println(i);
        }

        find(arr, i + 1, key);
    }

    // first occurence in an array
    public static int fOccur(int[] arr, int i, int key) {
        if (i == arr.length - 1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return fOccur(arr, i + 1, key);
    }

    // last occurence in an array
    public static int lOccur(int[] arr, int i, int key) {
        if (i == -1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return lOccur(arr, i - 1, key);
    }

    // power of a given number
    public static int calPow(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        return num * calPow(num, pow - 1);
    }

    public static int optPow(int num, int pow) {
        if (pow == 1) {
            return num;
        }
        if (num == 0) {
            return 0;
        }

        if (pow % 2 == 0) {
            return optPow(num, pow / 2) * optPow(num, pow / 2);
        } else {
            return num * optPow(num, pow / 2) * optPow(num, pow / 2);
        }

    }

    // length of a string
    public static void len(String str, int i) {
        if (i == str.length()) {
            System.out.println(i);
            return;
        }

        len(str, i + 1);
    }

    // number of digits in a number
    public static void nDigi(int num, int c) {
        if (num == 0) {
            System.out.println(c);
            return;
        }
        nDigi(num / 10, c + 1);
    }

    public static int nDigi(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + nDigi(num / 10);
    }

    // convert numbers into words
    public static void words(int n) {
        if (n == 0) {
            return;
        }

        words(n / 10);

        switch (n % 10) {
            case 1:
                System.out.print("one ");
                break;
            case 2:
                System.out.print("two ");
                break;
            case 3:
                System.out.print("three ");
                break;
            case 4:
                System.out.print("four ");
                break;
            case 5:
                System.out.print("five ");
                break;
            case 6:
                System.out.print("six ");
                break;
            case 7:
                System.out.print("seven ");
                break;
            case 8:
                System.out.print("eight ");
                break;
            case 9:
                System.out.print("nine ");
                break;
        }

    }

    public static void pi(String str, int i, String res) {

        if (i == str.length()) {
            System.out.println(res);
            return;
        }

        if (str.charAt(i) == 'p' && str.charAt(i + 1) == 'i') {
            pi(str, i + 2, res + "3.14");
        } else {
            pi(str, i + 1, res + str.charAt(i));
        }

    }

    // check string is palindrome or not
    public static boolean palindrome(String str, int i) {
        if (i == str.length() / 2) {
            return true;
        }

        if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
            return false;
        }

        return palindrome(str, i + 1);

    }

    // reverse the given array
    public static void revArr(int[] arr, int i) {

        if (i == arr.length / 2) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;

        revArr(arr, i + 1);

    }

    // reverse the given string
    public static void revStr(String str, int i, String res) {
        if (i < 0) {
            System.out.println(res);
            return;
        }

        revStr(str, i - 1, res + str.charAt(i));
    }

    public static void movX(String str, int i, String res, String x) {

        if (i == str.length()) {
            System.out.println(res + x);
            return;
        }

        if (str.charAt(i) == 'x') {
            movX(str, i + 1, res, x + 'x');
        } else {
            movX(str, i + 1, res + str.charAt(i), x);
        }
    }

    // print all subsequence of a string
    public static void subSeq(String str, int i, String res) {

        if (i == str.length()) {
            System.out.println(res);
            return;
        }

        subSeq(str, i + 1, res); // exclude
        subSeq(str, i + 1, res + str.charAt(i)); // include

    }

    // print all unique subsequence of a string
    public static void unqSubSeq(String str, int i, String res, HashSet<String> hSet) {

        if (i == str.length()) {
            if (!hSet.contains(res)) {
                System.out.println(res);
                hSet.add(res);
            }
            return;
        }

        unqSubSeq(str, i + 1, res + str.charAt(i), hSet);
        unqSubSeq(str, i + 1, res, hSet);

    }

    // print all substrings
    public static void subStr(String str, int i) {

        if (i == str.length()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = i; j < str.length(); j++) {
            sb.append(str.charAt(j));
            System.out.println(sb);
        }
        subStr(str, i + 1);

        // Another method _____
        /*
         * if (i == str.length()) {
         * return;
         * }
         * 
         * if (j == str.length()) {
         * subStr(str, i + 1, i + 1);
         * } else {
         * System.out.println(str.substring(i, j + 1));
         * subStr(str, i, j + 1);
         * }
         */

        // ____________________________________________________________________
        /*
         * Permutation is all types of arrangements = "abc","bca","cab",....
         * Combination is same as subsequence
         */

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a number : ");
        // int num = sc.nextInt();
        // System.out.println("Enter power : ");
        // int pow = sc.nextInt();

        // decOrder(num);
        // incOrder(num);

        // System.out.println(fact(num));
        // System.out.println(sum(num));
        // System.out.println(fib(num));

        // int arr[] = { 1, 2, 3, 4, 5 };
        // System.out.println(srted(arr, 0));
        // System.out.println(fOccur(arr, 0, 2));
        // System.out.println(lOccur(arr, arr.length - 1, 2));
        // find(arr, 0, 2);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }

        // System.out.println(calPow(num, pow));
        // System.out.println(optPow(2, 5));

        // len("bunty", 0);

        // System.out.println(nDigi(92123));

        // words(1947);

        // System.out.println(palindrome("paam", 0));

        // revArr(arr, 0);

        // String str = "bunty";
        // revStr(str, str.length() - 1, "");

        // pi("pippxxppiixipi", 0, "");

        // movX("abxcxxd", 0, "", "");

        // subSeq("1234", 0, "");

        // HashSet<String> hSet = new HashSet<>();
        // unqSubSeq("aaa", 0, "", hSet);

        // subStr("hello", 0, 0);
        subStr("hello", 0);

        sc.close();
    }
}
