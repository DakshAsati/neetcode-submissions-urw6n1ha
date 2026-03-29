/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long num1 = 0;
        long num2 = 0;
        long place = 1;

        while(l1 != null){
            num1 += l1.val * place;
            place *= 10;
            l1 = l1.next;
        }

        place = 1;

        while(l2 != null){
            num2 += l2.val * place;
            place *= 10;
            l2 = l2.next;
        }

        long sum = num1 + num2;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        if(sum == 0) return new ListNode(0);

        while(sum > 0){
            curr.next = new ListNode((int)(sum % 10));
            sum /= 10;
            curr = curr.next;
        }

        return dummy.next;
    }
}