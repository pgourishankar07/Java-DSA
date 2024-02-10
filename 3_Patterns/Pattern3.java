import java.util.*;

public class Pattern3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        int n = 65;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print((char) n);
                n++;

            }
            System.out.println();
        }

        sc.close();
    }
}
