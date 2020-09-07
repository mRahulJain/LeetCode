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
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger N1;
        BigInteger N2;
        String str = "";
        ListNode temp = l1;
        while(temp!=null) {
            str += temp.val;
            temp = temp.next;
        }
        N1 = new BigInteger(str);
        str = "";
        temp = l2;
        while(temp!=null) {
            str += temp.val;
            temp = temp.next;
        }
        N2 = new BigInteger(str);
        BigInteger res = N1.add(N2);
        String result = ""+res;
        ListNode answer = null;
        ListNode prev = null;
        for(int i = 0; i<result.length(); i++) {
            ListNode node = new ListNode();
            node.val = Character.getNumericValue(result.charAt(i));
            node.next = null;
            if(i==0) {
                prev = node;
                answer = node;
            } else {
                prev.next = node;
                prev = node;
            }
        }
        return answer;
    }
}