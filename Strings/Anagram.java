import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str1, str2;

        System.out.println("Enter a string : ");
        str1 = sc.next();
        System.out.println("Enter another string : ");
        str2 = sc.next();

        char[] chArr1 = str1.toCharArray();
        Arrays.sort(chArr1);
        char[] chArr2 = str2.toCharArray();
        Arrays.sort(chArr2);

        if (Arrays.equals(chArr1, chArr2)) {
            System.out.println("It an Anagram");
        } else {
            System.out.println("Not an Anagram");
        }

        sc.close();
    }
}
