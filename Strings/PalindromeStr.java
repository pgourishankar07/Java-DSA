import java.util.Scanner;

public class PalindromeStr {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String str = sc.nextLine();
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) == (str.charAt(n - i - 1))) {
                continue;
            } else {
                System.out.println("Not a palindrome");
                break;
            }
        }
        sc.close();
    }
}
