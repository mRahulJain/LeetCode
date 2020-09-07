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
    int i = 0;
    int answer = 0;
    public int getDecimalValue(ListNode head) {
        evaluateAnswer(head);
        return answer;
    }
    
    private void evaluateAnswer(ListNode head) {
        if(head == null) {
            return;
        }
        
        evaluateAnswer(head.next);
        answer += (head.val)*((int)Math.pow(2,i));
        i++;
    }
}