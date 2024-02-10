import java.util.Scanner;

public class Rotations {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String : ");
        String str = sc.next();

        System.out.println("Enter a String : ");
        String str2 = sc.next();

        StringBuilder arr[] = new StringBuilder[str.length()];

        StringBuilder strbuild = new StringBuilder(str);
        for (int i = 0; i < arr.length; i++) {
            strbuild.append(strbuild.charAt(0));
            strbuild.deleteCharAt(0);
            arr[i] = new StringBuilder(strbuild);
        }

        for (int i = 0; i < arr.length; i++) {
            if (str2.equals(arr[i].toString())) {
                System.out.println("Present :" + arr[i]);
            }
        }

        sc.close();
    }
}
