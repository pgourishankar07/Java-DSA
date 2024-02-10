import java.util.*;

public class PrimeNumOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int flag = 0;

        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = 0;
                break;
            } else {
                flag = 1;
            }
        }

        if (flag == 0) {
            System.out.print("Not a Prime Number");
        } else {

            System.out.print("Prime Number");
        }

        sc.close();
    }
}
