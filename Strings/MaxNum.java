import java.util.Scanner;

public class MaxNum {
    public static void main(String args[]) {
        String str;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string of numbers : ");
        str = sc.next();
        int arr[] = new int[10];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 48]++;
        }

        StringBuilder strb = new StringBuilder("");

        for (int i = arr.length - 1; i >= 0; i--) {
            while (arr[i] != 0) {
                strb.append(i);
                // System.out.print(i);
                arr[i]--;
            }
        }

        str = strb.toString();
        int intValue = Integer.parseInt(str);
        System.out.println("Maximum number Formed :" + intValue);

        sc.close();

    }
}
