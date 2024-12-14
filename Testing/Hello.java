import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {

        // _______________________Integer

        double num = 5.65f; // declare

        System.out.println("Enter your number");

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        sc.nextLine(); // to clear the buffer

        System.out.println("Your number is :" + num);

        // _____________String

        String name; // declare

        System.out.println("Enter your name");

        name = sc.nextLine();

        System.out.println("Your name is : " + name);

        sc.close();

        // primitive data types - int-BigInt,char,boolean

    }
}