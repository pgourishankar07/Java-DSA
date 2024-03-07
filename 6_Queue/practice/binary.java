import java.util.Scanner;

public class binary {
    public static void bin(int num) {
        while (num != 0) {
            System.out.print(num % 2);
            num = num / 2;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            bin(i);
            System.out.println();
        }
    }
}
