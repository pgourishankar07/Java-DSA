import java.util.Arrays;

public class reverse {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("example");

        char[] cArr = str.toString().toCharArray();

        Arrays.sort(cArr);

        for (int i = 0; i < cArr.length; i++) {
            System.out.print(cArr[i]);
        }
    }
}
