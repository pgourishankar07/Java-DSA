import java.util.*;

class Node {
    public int data;
    public Node next;

    public Node(int val) {
        data = val;
        next = null;
    }
}

public class _7_CircularLL {

    // INSERTION__________________________________________________
    static void inHead(Node[] head, int val) {

        Node newNode = new Node(val);

        if (head[0] == null) {
            head[0] = newNode;
            newNode.next = head[0];
            return;
        }

        Node temp = head[0];

        newNode.next = head[0];

        do {
            temp = temp.next;
        } while (temp.next != head[0]);

        temp.next = newNode;
        head[0] = newNode;

    }

    static void inBetween(Node[] head, int val, int pos) {

        if (pos <= 1 || head[0] == null) {
            inHead(head, val);
            return;
        }

        // getting the size of LL
        Node temp = head[0];

        int size = 0;

        do {
            temp = temp.next;
            size++;
        } while (temp != head[0]);

        // if position in last part so call inTail
        if (pos > size) {
            inTail(head, val);
            return;
        }

        // inBetween insertion logic
        int counter = 1;
        temp = head[0];
        Node newNode = new Node(val);

        do {
            counter++;
            if (pos == counter) {
                break;
            }
            temp = temp.next;
        } while (temp != head[0]);

        newNode.next = temp.next;
        temp.next = newNode;
    }

    static void inTail(Node[] head, int val) {

        if (head[0] == null) {
            inHead(head, val);
            return;
        }

        Node temp = head[0];
        Node newNode = new Node(val);

        do {
            temp = temp.next;
        } while (temp.next != head[0]);

        temp.next = newNode;
        newNode.next = head[0];

    }

    // DISPLAY__________________________________________________
    static void display(Node[] head) {
        Node temp = head[0];

        do {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        } while (temp != head[0]);
        System.out.println("...");
    }

    // DELETION __________________________________________________
    static void del(Node[] head, int pos) {
        if (head[0] == null) {
            System.out.println("No elements to delete");
            return;
        }

        if (head[0].next == null) {
            head[0] = null;
            return;
        }

        if (pos <= 1) { // deleting head part
            Node temp = head[0];
            do {
                temp = temp.next;
            } while (temp.next != head[0]);

            temp.next = temp.next.next;
            head[0] = temp.next;

            return;
        }

        // getting the size of LL
        Node temp = head[0];

        int size = 0;

        do {
            temp = temp.next;
            size++;
        } while (temp != head[0]);

        // if position in last part so inTail delete
        if (pos > size) {
            temp = head[0];
            do {
                temp = temp.next;
            } while (temp.next.next != head[0]);
            temp.next = head[0];
            return;
        }

        // inBetween insertion logic
        int counter = 0;
        temp = head[0];
        Node prev = null;

        do {
            counter++;
            if (pos == counter) {
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head[0]);

        prev.next = temp.next;
        temp.next = null;

    }

    public static void main(String args[]) {
        Node[] head = { null };

        inTail(head, 1);
        inTail(head, 2);
        inTail(head, 3);
        inHead(head, 4);
        display(head);
        System.out.println();
        inBetween(head, 5, 6);

        display(head);
        System.out.println();
        System.out.print("Default Circular LL Created :");
        del(head, 6);
        display(head);
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int f = 1;

        while (f == 1) {
            System.out.println("_____________CIRCULAR LL____________________");
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
                    inBetween(head, d2, k);
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
