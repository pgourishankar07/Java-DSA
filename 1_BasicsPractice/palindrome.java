import java.util.*;

public class palindrome {

    static int Fsize(int num) {

        int size = 0;
        while (num != 0) {
            num = num / 10;
            size++;
        }
        return size;

    }

    static int reversed(int num) {

        int pow = Fsize(num) - 1;
        int res = 0;
        int sumOfDigits = 0;
        while (num != 0) {
            sumOfDigits += num % 10;
            res = res + (int) ((num % 10) * Math.pow(10, pow));
            pow--;
            num = num / 10;
        }

        System.out.println("Sum of Digits : " + sumOfDigits);

        return res;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check Palindrome or not : ");
        int num = sc.nextInt();
        System.out.println(num == reversed(num));
        sc.close();
    }
}
