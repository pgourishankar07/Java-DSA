// Leetcode:234. Palindrome Linked List
/*
 * 
 * public class _4_impQ2 {
 * static ListNode rev(ListNode temp) {
 * 
 * ListNode prevNode = temp;
 * ListNode currNode = prevNode.next;
 * 
 * while (currNode != null) {
 * 
 * ListNode nextNode = currNode.next;
 * 
 * currNode.next = prevNode;
 * 
 * prevNode = currNode;
 * currNode = nextNode;
 * }
 * temp.next = null;
 * temp = prevNode;
 * 
 * return temp;
 * }
 * 
 * public boolean isPalindrome(ListNode head) {
 * 
 * if (head == null || head.next == null) {
 * return true;
 * }
 * 
 * // copying the LL_____________
 * 
 * ListNode newHead = new ListNode(head.val);
 * ListNode current = newHead;
 * 
 * ListNode temp = head;
 * while (temp != null) {
 * current.next = new ListNode(temp.val);
 * temp = temp.next;
 * current = current.next;
 * }
 * newHead = newHead.next; // for skiping the first element
 * 
 * // checking both LL____________
 * 
 * ListNode org = head;
 * ListNode reversed = rev(newHead);
 * 
 * while (reversed != null) {
 * if (org.val != reversed.val) {
 * return false;
 * }
 * reversed = reversed.next;
 * org = org.next;
 * }
 * 
 * return true;
 * 
 * }
 * }
 * 
 */