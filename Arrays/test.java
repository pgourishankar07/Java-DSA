public class test {
    public static void get(int n, int index) {
        int bitMask = 1 << index;
        if ((n & bitMask) != 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String args[]) {
        // int n = 5;
        // get(n, 4);
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(17));
        System.out.println(Integer.toBinaryString(53));
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(22));
        System.out.println(Integer.toBinaryString(9));

    }
}