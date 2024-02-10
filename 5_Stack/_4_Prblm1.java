
//Push at the bottom of stack and reverse the stack

import java.util.*;

public class _4_Prblm1 {

    public static void addToBotm(int data, Stack<Integer> s) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        addToBotm(data, s);
        s.push(top);
        return;
    }

    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverse(s);
        addToBotm(top, s);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // addToBotm(4, s);

        reverse(s);

        // Display pattern______________
        System.out.println();

        while (!s.isEmpty()) {
            System.out.println("|   |");
            System.out.println("| " + s.pop() + " |");
            System.out.println("|___|");
        }
        System.out.println();

    }

}
