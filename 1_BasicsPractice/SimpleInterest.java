import java.util.*;

public class SimpleInterest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principle amount : ");
        int p = sc.nextInt();

        System.out.print("Enter Rate : ");
        int r = sc.nextInt();

        System.out.print("Enter time : ");
        int t = sc.nextInt();

        int result = (p * r * t) / 100;
        System.out.println("Result : " + result);

        sc.close();

    }
}
