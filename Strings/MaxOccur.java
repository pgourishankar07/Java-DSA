import java.util.Scanner;

public class MaxOccur {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String : ");
        String str = sc.next();

        int arr[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        int max = 0;
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                m = i;
            }
        }
        System.out.println("Maximum occured Character is : " + str.charAt(m) + " Number of times :" + max);
        sc.close();
    }
}
