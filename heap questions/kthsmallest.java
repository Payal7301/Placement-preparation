import java.util.*;

public class kthsmallest{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }

        int k=scn.nextInt();
        int ans=getkthsmallest(arr,k);
        System.out.println(ans);
    }

    public static int getkthsmallest(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(k,Collections.reverseorder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]<pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        int ans=pq.remove();
        return ans;
       
    }
}