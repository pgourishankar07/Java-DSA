import java.util.*;

class Node {
    public int data;
    public Node next;

    public Node(int val) {
        data = val;
        next = null;
    }
}

public class _2_CrudOp2 {

    // INSERT______________________________________________________________________________
    // Insert in head_______________________________
    static void inHead(Node[] head, int val) {

        Node newNode = new Node(val);

        newNode.next = head[0];
        head[0] = newNode;
    }

    // Insert in between_______________________________
    static void inBetween(Node[] head, int key, int val) {

        Node newNode = new Node(val);
        Node temp = head[0];

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element not found");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Insert at the tail_______________________________
    static void inTail(Node[] head, int val) {

        Node newNode = new Node(val);

        if (head[0] == null) {
            head[0] = newNode;
            return;
        }

        Node temp = head[0];

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // DISPLAY______________________________________________________________________________
    static void display(Node[] head) {

        Node temp = head[0];

        System.out.print("Now the Linked List is: ");

        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // SEARCH______________________________________________________________________________
    static void search(Node[] head, int key) {

        Node temp = head[0];

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Element " + key + " not found in the linked list");
        } else {
            System.out.println("Element " + key + " found in the linked list");
        }
    }

    // DELETE______________________________________________________________________________
    static void delete(Node[] head, int key) {

        Node temp = head[0];
        Node prev = null;

        if (temp != null && temp.data == key) {
            head[0] = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element " + key + " not found to delete");
            return;
        }

        prev.next = temp.next;
        temp.next = null;
    }

    // REVERSE__________________________________________________________________
    static void rev(Node[] head) {

        if (head[0] == null || head[0].next == null) {
            System.out.println("Can't Reverse due to very small LL (containing only 1 element)");
            return;
        }

        Node prevNode = null;
        Node currNode = head[0];
        Node nextNode = null;

        while (currNode != null) {

            nextNode = currNode.next;

            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }
        head[0].next = null;
        head[0] = prevNode;
    }

    // recursive method of reversing the LL_______________________________
    static Node revRec(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive case: Reverse the rest of the list
        Node newHead = revRec(head.next);

        // Reverse the current node
        head.next.next = head;
        head.next = null;

        // Return the new head of the reversed list
        return newHead;
    }

    // MIDDLE of the node___________________________________________________
    static void mid(Node[] head) {

        if (head[0] == null || head[0].next == null) {
            return;
        }

        Node temp1 = head[0];
        Node temp2 = head[0];

        while (temp2 != null && temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }

        System.out.println("Middle Node of the LL : " + temp1.data);
    }

    // REVERSE K-Nodes __________________________________________________________
    static Node reverseK(Node head, int k) {

        // Counting number of nodes

        Node temp = head;
        int size = 0;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Base case

        if (k == 0 || head.next == null || size < k) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node nxt = null;

        int c = 0;

        while (curr != null && c < k) {
            nxt = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nxt;

            c++;
        }

        if (curr != null) {
            head.next = reverseK(curr, k);
        }

        head = prev;

        return head;
    }

    // APPEND K NODES at head______________________________________________
    static void appendKnodes(Node[] head, int k) {

        // getting the size of LL
        int size = 0;
        Node temp = head[0];
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int index = size - k;
        int counter = 1;

        // getting the part of the LL
        temp = head[0];
        while (temp != null) {
            if (counter == index) {
                break;
            }
            counter++;
            temp = temp.next;
        }

        // appending the part to the head

        Node temp2 = temp.next;
        temp.next = null;

        Node oldHead = head[0];
        head[0] = temp2; // assign the nth node as head

        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = oldHead;

    }
    // ____________________________MAIN__________________________________________________

    public static void main(String[] args) {

        Node[] head = { null };

        // inTail(head, 1);
        // inTail(head, 2);
        // inTail(head, 3);
        inHead(head, 1);
        inHead(head, 2);
        inHead(head, 3);
        inHead(head, 4);
        inHead(head, 5);
        inHead(head, 6);
        inHead(head, 7);
        inHead(head, 8);
        // inHead(head, 9);
        // inHead(head, 9);
        // inBetween(head, 1, 8);

        System.out.println("The Initial linked list created : ");
        display(head);

        // System.out.println("head[0].data=" + head[0].data);
        // System.out.println("head[0].next=" + head[0]);

        Scanner sc = new Scanner(System.in);
        int f = 1;

        while (f == 1) {
            System.out.println("_________________________________");
            System.out.println("1. Inserting at head");
            System.out.println("2. Inserting in between");
            System.out.println("3. Inserting at end");
            System.out.println("4. Display Linked list");
            System.out.println("5. Search an Element");
            System.out.println("6. Delete an Element ");
            System.out.println("7. Reverse the LL");
            System.out.println("8. Middle of the LL");
            System.out.println("9. Reverse Nodes in K-Group");
            System.out.println("10. Append last K nodes to inital part of LL ");
            System.out.println("11. Exit");
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
                    System.out.print("Enter previous Element: ");
                    int k = sc.nextInt();
                    inBetween(head, k, d2);
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
                    System.out.print("Enter Element to search: ");
                    int k2 = sc.nextInt();
                    search(head, k2);
                    break;
                case 6:
                    System.out.print("Enter data to be deleted: ");
                    int d4 = sc.nextInt();
                    delete(head, d4);
                    break;
                case 7:
                    rev(head);
                    // head[0] = revRec(head[0]); //for recursive method
                    display(head);
                    break;

                case 8:
                    mid(head);
                    break;

                case 9:
                    System.out.print("Enter K Value : ");
                    int kVal = sc.nextInt();
                    System.out.println("The Reversed linked list in K-Group : ");
                    head[0] = reverseK(head[0], kVal);
                    display(head);
                    break;
                case 10:
                    System.out.print("Enter K Value : ");
                    kVal = sc.nextInt();
                    appendKnodes(head, kVal);
                    display(head);
                    break;
                case 11:
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
