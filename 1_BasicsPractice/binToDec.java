import java.util.*;

public class binToDec {

    static int decimal(int bin) {

        int pow = 0;
        int dec = 0;

        while (bin != 0) {
            int ld = bin % 10;
            dec = dec + (int) (ld * Math.pow(2, pow));
            pow++;
            bin = bin / 10;
        }

        return dec;
    }

    static int binary(int dec) {

        int bin = 0;
        int pow = 0;
        while (dec != 0) {
            bin = bin + (int) ((dec % 2) * Math.pow(10, pow));
            pow++;
            dec = dec / 2;
        }
        // bin = bin + (int) ((dec % 2) * Math.pow(10, pow));
        return bin;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a binary Number (0/1): ");
        int num = sc.nextInt();
        System.out.println("Decimal Number : " + decimal(num));
        System.out.println(binary(7));
        sc.close();
    }
}
