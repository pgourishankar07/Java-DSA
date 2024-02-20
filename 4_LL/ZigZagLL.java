class Node {
    int val;
    Node next;

    Node() {
        next = null;
    }

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ZigZagLL {

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    static Node midpoint(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    static Node revLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node nxt = null;

        while (curr != null) {
            nxt = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nxt;
        }

        return prev;
    }

    static void zigzag(Node head) {

        Node mid = midpoint(head);

        Node left = head;
        Node right = revLL(mid.next);
        mid.next = null;

        Node res = new Node(0);
        Node temp = res;

        while (left != null && right != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;

            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        printLL(res.next);
    }

    public static void main(String args[]) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        zigzag(head);
    }
}
