public class SortedLL {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
            this.next = null;
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    class Solution {

        public ListNode midpoint(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = head;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            return prev;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode mergedLL = new ListNode(-1);
            ListNode temp = mergedLL;

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

            return mergedLL.next;
        }

        public ListNode divide(ListNode head) {
            if (head.next == null) {
                return head;
            }

            ListNode mid = midpoint(head);

            ListNode left = head;
            ListNode right = mid.next;

            mid.next = null;

            ListNode newLeft = divide(left);
            ListNode newRight = divide(right);

            return merge(newLeft, newRight);

        }

        public ListNode sortList(ListNode head) {

            if (head == null) {
                return head;
            }

            return divide(head);
        }

    }

}
