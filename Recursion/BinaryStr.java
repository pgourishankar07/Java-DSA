public class BinaryStr {

    public static void binStrNoConsecutive0(int n, int lPlace, String strB) {

        if (n == 0) {
            System.out.println(strB);
            return;
        }

        binStrNoConsecutive0(n - 1, 1, strB + "1");
        if (lPlace == 1) {
            binStrNoConsecutive0(n - 1, 0, strB + "0");
        }

    }

    public static void binStrNoConsecutive1(int n, int lPlace, String strB) {

        if (n == 0) {
            System.out.println(strB);
            return;
        }

        binStrNoConsecutive1(n - 1, 0, strB + "0");
        if (lPlace == 0) {
            binStrNoConsecutive1(n - 1, 1, strB + "1");
        }

    }

    public static void main(String args[]) {

        binStrNoConsecutive1(2, 0, "");
        System.out.println();
        binStrNoConsecutive0(2, 1, "");
    }
}
