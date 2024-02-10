public class BasicArr {

    public static class stack {

        private int[] stack;
        private int top;

        public stack() {
            stack = new int[100];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(int val) {
            top++;
            stack[top] = val;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int topVal = stack[top];
            top--;
            return topVal;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return stack[top];
        }
    }

    public static void main(String[] args) {

        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // Display pattern
        System.out.println();

        while (!s.isEmpty()) {
            System.out.println("|   |");
            System.out.println("| " + s.pop() + " |");
            System.out.println("|___|");
        }
        System.out.println();
    }
}
