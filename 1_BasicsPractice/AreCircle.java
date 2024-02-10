import java.util.*;

public class AreCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Radius of the Circle : ");
        float r = sc.nextFloat();

        System.out.print("Area of the Circle : " + 3.14 * r * r);

        sc.close();
    }
}
