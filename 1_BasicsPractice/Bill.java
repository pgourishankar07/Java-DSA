import java.util.*;

public class Bill {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter How many Items ? : ");
            int num = sc.nextInt();

            String items[] = new String[num];
            int prices[] = new int[num];
            int qty[] = new int[num];
            int i = 0;
            for (; i < num; i++) {
                System.out.print("Enter Item " + (int) (i + 1) + " Name : ");
                items[i] = sc.next();
                System.out.print("Enter Item " + (i + 1) + " Price : ");
                prices[i] = sc.nextInt();
                System.out.print("Enter Item " + (i + 1) + " Quantity : ");
                qty[i] = sc.nextInt();
            }
            sc.close();

            int total = 0;

            for (i = 0; i < num; i++) {
                total += prices[i] * qty[i];
            }
            float gst = ((float) 18 / (float) 100) * total;

            float totalAmt = total + gst;

            System.out.println("__________BILL_________");
            System.out.println("ITEMS\tQuantity\tPRICE");
            for (i = 0; i < num; i++) {
                System.out.println(items[i] + "\t\t" + qty[i] + "\t" + prices[i]);
            }

            System.out.println("GST\t\t" + gst);
            System.out.println("______________________");

            System.out.println("TOTAL" + "\t\t" + totalAmt);
        }

        System.out.println("______________________");

    }
}
