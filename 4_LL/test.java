class Node {
    int val;
    Node next;

    Node() {
        next = null;
    }

    Node(int val) {
        this.val = val;
        next = null;
    }
}

public class test {

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    static void linkdelete(Node head, int M, int N) {

        Node temp = head;
        Node prev = null;

        while (temp != null) {

            for (int i = 0; i < M && temp != null; i++) {
                prev = temp;
                temp = temp.next;
            }

            for (int i = 0; i < N && temp != null; i++) {
                temp = temp.next;
            }

            prev.next = temp;
        }

        printLL(head);

    }

    public static void main(String args[]) {
        Node head = new Node(9);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next.next = new Node(1);

        linkdelete(head, 2, 1);

        // printLL(head);
    }
}