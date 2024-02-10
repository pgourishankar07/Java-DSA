import java.util.*;

public class pattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int num = sc.nextInt();
        System.out.print("Enter a True / Fasle : ");
        boolean val = sc.nextBoolean();
        System.out.println(val);

        for (int i = num; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        sc.close();

    }
}
