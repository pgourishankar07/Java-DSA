import java.util.LinkedList;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }

}

public class Merge2LL {

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    static void merge(LinkedList<Integer> head1, LinkedList<Integer> head2) {
        LinkedList<Integer> mergedLL = new LinkedList<>();

        int i = 0, j = 0;
        while (i < head1.size() && j < head2.size()) {
            if (head1.get(i) < head2.get(j)) {
                mergedLL.add(head1.get(i));
                i++;
            } else {
                mergedLL.add(head2.get(j));
                j++;
            }
        }

        while (i < head1.size()) {
            mergedLL.add(head1.get(i));
            i++;
        }

        while (j < head2.size()) {
            mergedLL.add(head2.get(j));
            j++;
        }

        System.out.println("Merged LinkedList: " + mergedLL);
    }

    // ____________________Merge Sort______________________
    static Node midpoint(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev = head; // for getting the previous node of the mid node because u need to point that
                          // prev node to null

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    static Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        mergedLL = mergedLL.next;
        return mergedLL;
        // System.out.print("Merged LL : ");
        // printLL(mergedLL);

    }

    static Node divide(Node head) {
        if (head == null || head.next == null) { // if u pass null as head to the function
            return head;
        }

        Node mid = midpoint(head);

        Node left = head;
        Node right = mid.next;

        mid.next = null;

        Node newLeft = divide(left);
        Node newRight = divide(right);

        return merge(newLeft, newRight);
    }

    public static void main(String args[]) {
        // Node head1 = new Node(5);
        // head1.next = new Node(9);
        // head1.next.next = new Node(11);

        // Node head2 = new Node(3);
        // head2.next = new Node(8);
        // printLL(head1);
        // printLL(head2);

        // LinkedList<Integer> ll1 = new LinkedList<>();
        // ll1.addLast(5);
        // ll1.addLast(9);
        // ll1.addLast(11);
        // LinkedList<Integer> ll2 = new LinkedList<>();
        // ll2.addLast(3);
        // ll2.addLast(8);
        // merge(ll1, ll2);

        // merge(head1, head2);

        Node temp = new Node(8);
        temp.next = new Node(2);
        temp.next.next = new Node(6);
        temp.next.next.next = new Node(3);
        temp.next.next.next.next = new Node(1);
        temp.next.next.next.next.next = new Node(9);

        // System.out.println(midpoint(temp).next.val);

        Node sorted = divide(temp);

        while (sorted != null) {
            System.out.print(sorted.val + " -> ");
            sorted = sorted.next;
        }
        System.out.print("NULL");
    }
}
