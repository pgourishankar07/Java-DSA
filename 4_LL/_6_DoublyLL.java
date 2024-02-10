import java.util.Scanner;

class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int val) {
        data = val;
        prev = null;
        next = null;
    }
}

public class _6_DoublyLL {

    // INSERTION ________________________________________
    static void inHead(Node[] head, int val) {
        Node newHead = new Node(val);

        newHead.next = head[0];

        if (head[0] != null) {
            head[0].prev = newHead;
        }

        head[0] = newHead;
    }

    static void inBtwn(Node[] head, int val, int pos) {

        // if position is head then pass to inhead
        if (pos <= 1 || head[0] == null) {
            inHead(head, val);
            return;
        }

        // getting the size of LL
        Node temp = head[0];

        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // if position in last part so call inTail
        if (pos >= size) {
            inTail(head, val);
            return;
        }

        // inBetween insertion logic
        int counter = 1;
        temp = head[0];
        Node newNode = new Node(val);

        while (temp.next != null) {
            counter++;
            if (pos == counter) {
                break;
            }
            temp = temp.next;
        }

        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;

    }

    static void inTail(Node[] head, int val) {

        if (head == null) {
            inHead(head, val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head[0];

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // DISPLAY____________________________________________
    static void display(Node[] head) {
        Node temp = head[0];

        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");

    }

    // DELETION________________________________________________
    static void del(Node[] head, int pos) {

        if (head[0] == null) {
            System.out.println("No elements to delete");
            return;
        }

        if (head[0].next == null) {
            head[0] = null;
            return;
        }

        if (pos <= 1) { // deleting head
            head[0] = head[0].next;
            head[0].prev = null;
            return;
        }

        // getting the size of LL
        Node temp = head[0];
        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head[0];

        // if position in last part so call delete inTail
        if (pos >= size) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;
            return;
        }

        // if position is middle or in betwen deletion
        int counter = 1;
        temp = head[0];

        while (temp.next != null) {
            if (pos == counter) {
                break;
            }
            counter++;
            temp = temp.next;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
    }

    public static void main(String args[]) {

        Node[] head = { null };

        inHead(head, 1);
        inHead(head, 3);
        inHead(head, 2);
        inTail(head, 5);
        inTail(head, 4);

        display(head);
        System.out.println();
        inBtwn(head, 10, 3);

        display(head);
        System.out.println();

        del(head, 6);
        display(head);

        Scanner sc = new Scanner(System.in);
        int f = 1;

        while (f == 1) {
            System.out.println("_____________DOUBLLY LL____________________");
            System.out.println("1. Inserting at head");
            System.out.println("2. Inserting in between");
            System.out.println("3. Inserting at end");
            System.out.println("4. Display Linked list");
            System.out.println("5. Delete an Element ");
            System.out.println("6. Exit");
            System.out.println("_________________________________");
            System.out.print("Enter option number: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter data: ");
                    int d1 = sc.nextInt();
                    inHead(head, d1);
                    System.out.println("Element " + d1 + " has been inserted in the Linked List");
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    int d2 = sc.nextInt();
                    System.out.print("Enter position of the Element: ");
                    int k = sc.nextInt();
                    inBtwn(head, d2, k);
                    System.out.println("Element " + d2 + " has been inserted in the Linked List");
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    int d3 = sc.nextInt();
                    inTail(head, d3);
                    System.out.println("Element " + d3 + " has been inserted in the Linked List");
                    break;
                case 4:
                    display(head);
                    break;
                case 5:
                    System.out.print("Enter position to be deleted: ");
                    int d4 = sc.nextInt();
                    del(head, d4);
                    break;
                case 6:
                    System.out.println("Successfully Exited....");
                    f = 0;
                    break;
                default:
                    System.out.println("Invalid option ... !");
            }
        }

        sc.close();

    }
}
