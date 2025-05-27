
public class test {
    static void convertToBin(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            if ((n & 1) == 1) {
                ans.append(Integer.toString(1));
            } else {
                ans.append(Integer.toString(0));
            }
            n = n >> 1;
        }
        System.out.println(ans.reverse());
    }

    public static void main(String args[]) {
        System.out.println(-~3); // -~x = x + 1
        System.out.println(~-3); // -~x = x + 1
        System.out.println(~-0);

        convertToBin(5);

    }
}
