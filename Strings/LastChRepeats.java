import java.util.Scanner;

public class LastChRepeats {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String str = sc.next();

        int arr[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'a'] > 1) {
                System.out.println("Left-Most Repeating Element : " + str.charAt(i));
                break;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'a'] == 1) {
                System.out.println("Left-Most Non-Repeating Element : " + str.charAt(i));
                break;
            }
        }

        sc.close();
    }
}
