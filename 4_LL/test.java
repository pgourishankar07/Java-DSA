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

        int count = 0;

        while (temp != null) {
            if (count == M) {
                int skip = N;
                while (skip != 0) {
                    System.out.println(temp.val);
                    temp = temp.next;
                    skip--;
                }
                count = -1;
                prev.next = temp.next;
            }
            count++;
            prev = temp;
            temp = temp.next;
        }

        printLL(head);

        // while (temp != null) {
        // prev = temp;
        // if (count == M) {
        // prev.next = temp.next;
        // count = 0;
        // }
        // count++;
        // temp = temp.next;
        // }

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

        linkdelete(head, 1, 2);

        // printLL(head);
    }
}