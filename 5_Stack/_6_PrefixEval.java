import java.util.Scanner;
import java.util.Stack;

public class _6_PrefixEval {

    public static int preEval(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                stack.push(str.charAt(i) - '0');
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
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

    public static int preEvalWithSpace(String str) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = str.split("\\s+"); // Split the input string into tokens(substrings) wherever space is
                                             // encountered
        // If str is, for example, "+ 9 * 12 6", then the resulting array (tokens) would
        // be ["+","9","*","12","6"]
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (tokens[i].matches("\\d+")) { // Check if the token is a number
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
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
        System.out.print("Enter prefix (polish notation) : ");
        String str = sc.nextLine();

        System.out.println("Result : " + (str.contains(" ") ? preEvalWithSpace(str) : preEval(str)));
        sc.close();
    }
}

// Study Prefix,Infix,Postfix
/*
 * https://www.youtube.com/watch?v=4pIc9UBHJtk&list=
 * PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=3
 * 1. postfix evaluation - go from left to right beacause at left end only
 * contains alphabet
 * 2. prefix evaluation - go from right to left beacause at right end only
 * contains alphabet
 * 3. infix to postfix
 * 4. infix to prefix - i. reverse the input -> and change the brackets -> do
 * infix to postfix ops -> reverse the ans
 * 5. postfix to infix - i. go from left to right -> whenever operator comes u
 * pop two operands and place operator btwn them and close with bracket -> push
 * into stack
 * 6. prefix to infix - i. same as above but go from right to left and sequece
 * of chars should be same as in q.
 * 7. postfix to prefix - i.go from left to right -> if operator comes then pop
 * top1 and top2 -> and push in stack in the format 'op-t2-t1'
 * 8. prefix to postfix - i.go from right to left -> same as above format is
 * 't1-t2-op'
 */