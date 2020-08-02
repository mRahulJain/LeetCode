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
import java.math.BigDecimal;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int radix = 10;
        
        int n1 = countList(l1);
        System.out.println(n1);
        int n2 = countList(l2);
        System.out.println(n2);
        BigInteger number1 = makeNumber(l1, n1);
        System.out.println(number1);
        BigInteger number2 = makeNumber(l2, n2);
        System.out.println(number2);
        BigInteger sum = number1.add(number2);
        System.out.println(sum);
        String s = sum.toString(radix);
        System.out.println(s);
        ListNode sumList = makeList(s);
        return sumList;
    }
    
    public static ListNode makeList(String s) {
        ListNode finalList = new ListNode();
        ListNode tempList = new ListNode();
        for(int i = s.length() - 1; i>=0; i--) {
            if(i==s.length() - 1) {
                tempList = new ListNode(Character.getNumericValue(s.charAt(i)), null);
                finalList = tempList;
            } else {
                ListNode node = new ListNode(Character.getNumericValue(s.charAt(i)), null);
                tempList.next = node;
                tempList = tempList.next;
            }
        }
        return finalList;
    }
    
    public static BigInteger makeNumber(ListNode l, int n) {
        int radix = 10;
        
        BigInteger number = new BigInteger("0");
        BigInteger multiplier = new BigInteger("1");
        while(l != null) {
            BigInteger myN = new BigInteger(Integer.toString(l.val));
            BigInteger myNumber = myN.multiply(multiplier);
            number = number.add(myNumber);
            multiplier = multiplier.multiply(new BigInteger("10"));
            l = l.next;
        }
        return number;
    }
    
    public static int countList(ListNode l) {
        int count = 0;
        while(l.next != null) {
            count++;
            l = l.next;
        }
        return count;
    }
}