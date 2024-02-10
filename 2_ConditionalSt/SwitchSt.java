import java.util.*;

public class SwitchSt {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter number 1/2/3 : ");
        num = sc.nextInt();

        switch (num) {
            case 1:
                System.out.println("Samosa");
                break;
            case 2:
                System.out.println("paniPuri");
                break;
            case 3:
                System.out.println("Chat");
                break;
            default:
                System.out.println("Wrong Number");

        }

        sc.close();
    }
}
