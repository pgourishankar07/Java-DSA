public class test {
    record Pair(int s, int d) {
    }

    public static void main(String[] args) {
        Pair p = new Pair(10, 20);
        System.out.println(p.s());
        System.out.println(p.d());
    }

}