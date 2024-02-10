//Diamond

import java.util.*;

public class Pattern5 {

    public static void diamond(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    public static void rombus(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 5; j++) {
                if (i == 1 || i == 5 || j == 1 || j == 5) {

                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= (2 * n) - (2 * i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= (2 * n) - (2 * i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        // diamond(num);
        // rombus(num);
        butterfly(num);
        sc.close();
    }
}