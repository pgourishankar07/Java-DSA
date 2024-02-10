public class TilingPrblm {

    public static int tiles(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return tiles(n - 1) + tiles(n - 2);
    }

    public static void main(String args[]) {
        System.out.println(tiles(4));
    }
}
