public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode hOdd = head;
        ListNode hEven = head.next;
        ListNode hEvenCopy = head.next;
        
        while(hOdd!= null && hEven != null && hOdd.next!=null && hEven.next!=null) {
            hOdd.next = hOdd.next.next;
            hOdd = hOdd.next;
            
            hEven.next = hEven.next.next;
            hEven = hEven.next;
            
        }
        
        hOdd.next = hEvenCopy;
        
        return head;
    }
}