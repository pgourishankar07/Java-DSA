import java.util.Scanner;
import java.util.Stack;

public class _7_PostfixEval {

    public static int postEval(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                stack.push(str.charAt(i) - '0');
            } else {
                int operand2 = stack.pop(); // important change 1st op2 then op1
                int operand1 = stack.pop();
                int res;
                switch (str.charAt(i)) {
                    case '^':
                        res = (int) Math.pow(operand1, operand2);
                        stack.push(res);
                        break;
                    case '/':
                        res = operand1 / operand2;
                        stack.push(res);
                        break;
                    case '*':
                        res = operand1 * operand2;
                        stack.push(res);
                        break;
                    case '+':
                        res = operand1 + operand2;
                        stack.push(res);
                        break;
                    case '-':
                        res = operand1 - operand2;
                        stack.push(res);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static int postEvalWithSpace(String str) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = str.split("\\s+"); // Split the input string into tokens(substrings) wherever space is
                                             // encountered
        // If str is, for example, "+ 9 * 12 6", then the resulting array (tokens) would
        // be ["+","9","*","12","6"].
        for (int i = 0; i <= tokens.length - 1; i++) {
            if (tokens[i].matches("\\d+")) { // Check if the token is a number
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int res;
                switch (tokens[i]) {
                    case "^":
                        res = (int) Math.pow(operand1, operand2);
                        stack.push(res);
                        break;
                    case "/":
                        res = operand1 / operand2;
                        stack.push(res);
                        break;
                    case "*":
                        res = operand1 * operand2;
                        stack.push(res);
                        break;
                    case "+":
                        res = operand1 + operand2;
                        stack.push(res);
                        break;
                    case "-":
                        res = operand1 - operand2;
                        stack.push(res);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix (Reverse polish notation) : ");
        String str = sc.nextLine();

        System.out.println("Result : " + (str.contains(" ") ? postEvalWithSpace(str) : postEval(str)));
        sc.close();
    }
}
