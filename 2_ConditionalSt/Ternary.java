import java.util.*;

public class Ternary {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter a Number : ");
        num = sc.nextInt();

        String result = (num % 2 == 0) ? "Even" : "Odd";

        System.out.println(result);

        sc.close();
    }
}
