
public class _1_BasicStackLL {
    static class Node {
        public int data;
        public Node next;

        public Node(int val) {
            data = val;
            next = null;
        }
    }

    static class stack {

        public static Node head;

        public boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        public void push(int val) {
            Node newNode = new Node(val);

            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;

        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            return top;
        }
    }

    public static void main(String args[]) {
        stack s = new stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println();

        while (!s.isEmpty()) {
            System.out.println("|   |");
            System.out.println("| " + s.pop() + " |");
            System.out.println("|___|");
        }
        System.out.println();

    }
}
