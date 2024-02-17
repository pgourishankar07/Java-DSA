
public class oddEven {

    static void oddOrEven(int n) {
        if ((n & 1) == 0) {
            System.out.println("Even Number ");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static void main(String args[]) {
        oddOrEven(5);
        oddOrEven(4);
    }
}
