import java.util.Scanner;
import java.util.Stack;

public class _10_BalanceParanthesis {
    public static boolean balanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char c = stack.peek();
                int res = (c - str.charAt(i)) < 0 ? -1 * (c - str.charAt(i)) : (c - str.charAt(i));
                if (res > 10) {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of brackets : ");
        String str = sc.next();
        System.out.println(balanced(str));
        sc.close();
    }
}
