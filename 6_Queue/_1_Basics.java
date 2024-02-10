public class _1_Basics {

    public static class queue {

        int arr[];
        int rear = -1;
        int size;

        queue(int n) {
            size = n;
            arr = new int[n];
        }

        boolean isEmpty() {
            return rear == -1;
        }

        boolean isFull() {
            return rear == size - 1;
        }

        void enque(int val) { // O(1)
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear] = val;
        }

        int deque() { // O(n) so use circular queue while u use array
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        int peek() { // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[0];
        }

    }

    public static void main(String args[]) {
        queue q = new queue(5);

        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);

        while (!q.isEmpty()) {
            System.out.println(q.deque());
        }
        System.out.println(q.peek());

        queue qu = new queue(3);
        qu.enque(5);
        System.out.println(qu.peek());
    }
}
