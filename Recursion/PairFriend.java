public class PairFriend {
    public static int pairUp(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int singleWays = pairUp(n - 1);
        int pairWays = (n - 1) * pairUp(n - 2); // for each pair combine with other members

        return singleWays + pairWays;
    }

    public static void main(String args[]) {
        System.out.println(pairUp(4));
    }
}
