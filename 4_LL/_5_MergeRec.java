// leetcode : 21 (recursive method of solving the problem)

public class _5_MergeRec {
    public static void main(String args[]) {
    }

    static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node dummy;

        if (head1.data < head2.data) {
            dummy = head1;
            dummy.next = merge(head1.next, head2);
        } else {
            dummy = head2;
            dummy.next = merge(head1, head2.next);
        }

        return dummy;
    }
}