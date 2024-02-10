import java.util.Scanner;
import java.util.Stack;

public class _5_RevSentence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.nextLine();

        String[] arrOfStr = str.split(" ");

        Stack<String> s = new Stack<>();

        for (String a : arrOfStr)
            s.push(a);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();

        sc.close();
    }
}
