import java.util.*;

public class LeapYr {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int yr;
        System.out.print("Enter Year : ");
        yr = sc.nextInt();

        if (yr % 4 == 0) {
            if (yr % 100 == 0) {
                if (yr % 400 == 0) {

                    System.out.println("Its a Leap Year");
                } else {

                    System.out.println("Not a Leap Year");
                }
            } else {

                System.out.println("Its a Leap Year");
            }
        } else {
            System.out.println("Not a Leap Year");
        }

        sc.close();
    }
}
