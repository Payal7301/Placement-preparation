import java.util.*;

public class kthlargest{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }

        int k=scn.nextInt();
        int ans=getkthlargest(arr,k);
        System.out.println(ans);
    }

    public static int getkthlargest(int[] arr,int k){

        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(k,collections.reverseorder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            int element=arr[i];
            if(element<pq.peek()){
                pq.remove();
                pq.add(element);
            }
        }
        ans=pq.remove();

        return ans;
    }
}