import java.util.Scanner;

public class lexiRank {

    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static int LexicalRank(String str) {
        int n = str.length();
        int rank = 1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    count++;
                }
            }
            rank += count * (factorial(n - i - 1));
        }

        return rank;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String str = sc.next();

        System.out.println(LexicalRank(str));

        sc.close();

    }
}
