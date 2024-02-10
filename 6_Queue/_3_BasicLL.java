
public class _3_BasicLL {

    public static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public static class qLL {

        Node front = null;
        Node rear = null;

        boolean isEmpty() {
            return front == null && rear == null;
        }

        void add(int val) {
            Node newNode = new Node(val);

            if (isEmpty()) {
                front = rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
        }

        int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int val = front.data;
            if (front == rear) {
                front = rear = null;
                return val;
            }
            front = front.next;
            return val;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }
    }

    public static void main(String args[]) {

        qLL q = new qLL();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        System.out.println(q.peek());

        qLL q1 = new qLL();
        q1.add(5);
        q1.add(4);
        q1.add(3);
        q1.add(2);
        while (!q1.isEmpty()) {
            System.out.println(q1.remove());
        }
        System.out.println(q1.peek());
        System.out.println(q1.remove());
    }
}
