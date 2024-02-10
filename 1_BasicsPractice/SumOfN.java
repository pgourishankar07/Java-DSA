import java.util.*;

public class SumOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum += i;
        }

        System.out.println("Sum of first " + num + " Natural Numbers : " + sum);

        sc.close();
    }
}
