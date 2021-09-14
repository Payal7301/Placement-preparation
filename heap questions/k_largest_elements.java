
import java.io.*;

import java.util.*;
public class k_largest_elements{

    public static ArrrayList<Integer> klargestelements(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
            
        }
        for(int i=k;i<arr.size();i++){
        if(arr[i]>pq.peek()){
            pq.remove();
            pq.add(arr[i]);

        }
     }
     ArrayList<Integer> ans=new ArrayList<>();
     while(pq.size()!=0){
         ans.add(pq.remove());
     }
     Comparator c = Collections.reverseOrder();
     Collections.sort(ans, c);
     return ans;
     
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();

        ArrayList<Integer> ans=klargestelements(arr, k);
        for(int e:ans){
            System.out.println(e);
        }
        }
    }
}