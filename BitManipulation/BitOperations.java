
public class BitOperations {

    // indexing from rigth to left

    static int get_ith_bit(int n, int i) {
        int bitMask = 1 << i;

        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
        // return (n & bitMask); //this will return the decimal of that ith position
    }

    static int set_ith_bit(int n, int i) { // set ith bit as 1
        int bitMask = 1 << i;
        return n | bitMask;
    }

    static int clear_ith_bit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    static int update_ith_bit(int n, int i, int newBit) {
        if (newBit == 0) {
            return clear_ith_bit(n, i);
        } else {
            return set_ith_bit(n, i);
        }
    }

    static int clear_i_bits(int n, int i) {
        int bitMask = (~0 << i); // ~0 = 11111111 and move i = 4 elements right gives 11110000
        return n & bitMask;
    }

    static int clear_range_of_bits(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static void main(String args[]) {
        System.out.println(get_ith_bit(7, 2));
        System.out.println(set_ith_bit(10, 2));
        System.out.println(clear_ith_bit(10, 1));
        System.out.println(update_ith_bit(10, 1, 0));
        System.out.println(clear_i_bits(10, 4));
    }
}
