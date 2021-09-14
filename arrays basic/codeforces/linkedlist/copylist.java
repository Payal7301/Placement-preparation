import java.util.*;

class copylist {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void addSameInBtw(ListNode head){
        
        ListNode curr=head;
        ListNode Next=null;
        while(curr!=null){
        Next=curr.next;
        curr.next=new ListNode(curr.val);
        curr.next.next=Next;
        curr=Next;
        }
    }
    public static void SetRandom(ListNode head){
    ListNode curr=head;
    while(curr!=null){
        if(curr.random!=null){
    ListNode Random=curr.random;
    curr.next.random=Random.next;
        }else{
         curr.next.random=null;   
        }
        
        curr=curr.next.next;
    }
    }
    public static ListNode SeparateLists(ListNode head){
        ListNode nnode=new ListNode(-1);
        ListNode nt=nnode;
        ListNode curr=head;
        while(curr!=null){
        nt.next=curr.next;
        curr.next=curr.next.next;
        nt=nt.next;
        curr=curr.next;
        }
        
        return nnode.next;
    }
    public static ListNode copyRandomList(ListNode head) {
     addSameInBtw(head);
     SetRandom(head);
     ListNode ans=SeparateLists(head);
     return ans;
     
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}