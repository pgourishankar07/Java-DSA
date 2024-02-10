
class Node {
    int data;
    Node next;
}

public class _1_Basic {
    // This function prints contents of linked list
    // starting from the given node
    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("NULL");
    }

    // Driver's code
    public static void main(String[] args) {

        // allocate 3 nodes in the heap
        Node head = new Node();
        Node second = new Node();
        Node third = new Node();

        head.data = 1; // assign data in first node
        head.next = second; // Link first node with second

        second.data = 2; // assign data to second node
        second.next = third;

        third.data = 3; // assign data to third node
        third.next = null;

        // Function call
        printList(head);
    }
}
