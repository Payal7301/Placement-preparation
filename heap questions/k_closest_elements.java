import java.util.Collections;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class k_closest_elements {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }

        int k=scn.nextInt();
        int val=scn.nextInt();
        print_k_closest_element_to_val(arr,k,val);
    }
    // class Pair{
    //     int x;
    //     int y;
    //     public pair(int x,int y){
    //         this.x=x;
    //         this.y=y;
    //     }
    // }
    

    public void print_k_closest_element_to_val(int[] arr,int k,int val){
        PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            Pair<Integer,Integer> pair=new Pair<>(Math.abs(arr[i]-val),arr[i]);
            pq.add(pair);
            if(pq.size()>k){
                pq.remove();
            }

        }

        while(pq.size()>0){
            int element=pq.peek();
            System.out.println(element.getValue());
            pq.remove();
        }



    }
}
