import java.util.*;

public class MAxOf3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int a = sc.nextInt();
        System.out.print("Enter b number : ");
        int b = sc.nextInt();
        System.out.print("Enter c number : ");
        int c = sc.nextInt();

        if (a > b) {
            if (a > c) {
                System.out.print(a + " is the Max.  No.");
            } else {
                System.out.print(c + " is the Max.  No.");

            }

        } else {
            if (b > c) {
                System.out.print(b + " is the Max.  No.");
            } else {
                System.out.print(c + " is the Max.  No.");

            }
        }

        sc.close();
    }
}
