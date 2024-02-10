import java.util.Scanner;
import java.util.Stack;

public class _9_infToPre {

    public static String reverse(String str) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <= str.length() - 1; i++) {
            stack.push(str.charAt(i));
        }
        String rev = "";
        while (!stack.isEmpty()) {
            rev += stack.pop();
        }
        return rev;
    }

    public static String replaceBrac(String str) {
        String res = str.replace('(', '#');
        res = res.replace(')', '(');
        res = res.replace('#', ')');
        return res;
    }

    public static int prec(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '/' || c == '*') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    public static String infixToPostfix(String str) {
        Stack<Character> stack = new Stack<>();
        String res = "";

        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'
                    || str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res += str.charAt(i);
            } else if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    res += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(stack.peek()) >= prec(str.charAt(i))) {
                    res += stack.pop();
                }
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Expression : ");
        String str = sc.next();

        String reverStr = reverse(str);

        String replaceStr = replaceBrac(reverStr);

        String inToPost = infixToPostfix(replaceStr);

        String result = reverse(inToPost);

        System.out.println("PostFix Expression : " + result);
        sc.close();
    }
}
