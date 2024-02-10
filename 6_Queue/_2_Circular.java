
public class _2_Circular {
    public static class CircularQ {
        int arr[];
        int size;
        int front = -1;
        int rear = -1;

        CircularQ(int val) {
            size = val;
            arr = new int[val];
        }

        boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        boolean isFull() {
            return (rear + 1) % size == front; // r+1 == front
        }

        void enque(int val) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }

            if (front == -1) { // for 1st time enque
                front = 0;
            }
            rear = (rear + 1) % size; // increament (rear++)
            arr[rear] = val;
        }

        int deque() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int val = arr[front];

            if (front == rear) { // if there is only 1 element then bring to initial state
                front = rear = -1;
            } else {
                front = (front + 1) % size; // increament (front ++)
            }

            return val;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String args[]) {
        CircularQ q = new CircularQ(5);

        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);
        q.enque(6);
        q.deque();
        q.deque();
        System.out.println(q.peek());
        System.out.println(q.peek());
        while (!q.isEmpty()) {
            System.out.println(q.deque());
        }
    }
}
