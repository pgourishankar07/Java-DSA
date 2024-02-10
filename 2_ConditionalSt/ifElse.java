import java.util.*;

public class ifElse {
    public static void main(String args[]) {

        int income;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your LPA :");

        income = sc.nextInt();

        if (income < 5) {

            System.out.println("No Tax");
        } else if (income >= 5 && income <= 10) {
            System.out.print("Your Income Tax : " + (float) (0.2 * income));

        } else {
            System.out.print("Your Income Tax : " + (float) (0.3 * income));
            // System.out.format("%.2f", 0.3 * income);

        }

        sc.close();
    }
}