
public class oddEven {

    static void oddOrEven(int n) {
        if ((n & 1) == 0) {
            System.out.println("Even Number ");
        } else {
            System.out.println("Odd Number");
        }
    }

    static boolean powerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    static int count_1s(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    static int fastExpo(int a, int n) {
        int ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    static int noOfDigi(int n) {
        return (int) Math.log10(n) + 1;
    }

    public static void main(String args[]) {
        oddOrEven(5);
        oddOrEven(4);
        System.out.println(powerOf2(7));
        System.out.println(count_1s(3));
        System.out.println(fastExpo(3, 5));
        System.out.println(noOfDigi(16));
    }
}
