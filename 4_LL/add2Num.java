// Leetcode : 2
/*
 * 
 * public class add2Num {
 * public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 * 
 * if (l1.val == 0 && l2.val == 0 && l1.next == null && l2.next == null) {
 * ListNode res = new ListNode(0);
 * return res;
 * }
 * 
 * ListNode temp1 = l1;
 * ListNode temp2 = l2;
 * 
 * long val1 = 0;
 * long val2 = 0;
 * int pow1 = 0;
 * int pow2 = 0;
 * 
 * 
 * 
 * while (temp1 != null) {
 * val1 = val1 + (long) (temp1.val * Math.pow(10, pow1));
 * pow1++;
 * temp1 = temp1.next;
 * }
 * while (temp2 != null) {
 * val2 = val2 + (long) (temp2.val * Math.pow(10, pow2));
 * pow2++;
 * temp2 = temp2.next;
 * }
 * 
 * long sumUp = val1 + val2;
 * 
 * ListNode res = new ListNode(0);
 * ListNode ptr = res;
 * 
 * while (sumUp != 0) {
 * ptr.next = new ListNode((int) (sumUp % 10));
 * sumUp = sumUp / 10;
 * ptr = ptr.next;
 * }
 * return res.next;
 * 
 * }
 * }
 * 
 */