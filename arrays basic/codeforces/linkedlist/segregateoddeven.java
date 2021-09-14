package linkedlist;
import java.util.*;

class segregateoddeven {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
    ListNode even=new ListNode(-1);
    ListNode odd=new ListNode(-1);
    ListNode oddtemp=odd;
    ListNode eventemp=even;
    ListNode temp=head;
    while(temp!=null){
        if(temp.val%2==0){
            // even
            eventemp.next=temp;
            eventemp=eventemp.next;
            temp=temp.next;
            
        }else{
            // odd
            oddtemp.next=temp;
            oddtemp=oddtemp.next;
            temp=temp.next;
        }
    }
    oddtemp.next=null;
    even=even.next;
    eventemp.next=null;
    oddtemp.next=even;
    return odd.next;
    }
// [2,1,3,5,6,4,7]
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}