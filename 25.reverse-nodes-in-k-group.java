/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        for(int i = 0; i < k; i++) {
            if (current == null) return head;
            else {
                current = current.next;
            }
        }
        
        ListNode tail = null;
        ListNode pointer = null;
        ListNode cur = null;
        for(int i = 0; i < k; i++) {
            if (cur == null) {
                tail = head;
                pointer = head;
                cur = head.next;
            } else {
                pointer = cur;
                cur = cur.next;
                pointer.next = tail;
                tail = pointer;
            }
        }
        
        head.next = reverseKGroup(cur, k);
        return tail;
    }
}
