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

        void add(int val) { // O(1)
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear] = val;
        }

        int remove() { // O(n) so use circular queue while u use array
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = arr[0];

            for (int i = 0; i < rear; i++) { // move all the elements to the left
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

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        System.out.println(q.peek());

        queue qu = new queue(3);
        qu.add(5);
        System.out.println(qu.peek());
    }
}
