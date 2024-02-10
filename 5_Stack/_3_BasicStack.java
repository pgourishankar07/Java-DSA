import java.util.Stack;

public class _3_BasicStack {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

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
