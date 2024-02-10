import java.util.*;

public class Avg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many Subject ?");
        int n = sc.nextInt();

        int total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Subject " + (i + 1) + " Mark : ");
            int num = sc.nextInt();
            total += num;
        }

        System.out.print("Average Score : " + (total / n));

        sc.close();
    }
}
