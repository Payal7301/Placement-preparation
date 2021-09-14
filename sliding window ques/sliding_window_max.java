import java.util.ArrayDeque;
import java.util.Scanner;

public class sliding_window_max{

    public static int[] slidingwindowmax(int[] arr,int k){
        int[] ans=new int[arr.length-k+1];

        
        int i=0;
        int j=0;

        while(j<arr.length){
        // basic calculation->find max in window
        // elements left of window having value less than current element are'nt useful but on the right are useful
            ArrayDeque<Integer> list=new ArrayDeque<>();
          
                
                while (!list.isEmpty() && list.peek() < arr[j]) {
                    list.pollLast();
                  }
                    
                 list.add(arr[j]);
                 if(j-i+1<k){
                     j++;
                 }
                 
                //  shift and calculate answer
                if(j-i+1==k){
                    // answer
                    ans[i]=list.peekFirst();
                    // shift i and j and remove its calculation
                    if(list.peekFirst()==arr[i]){
                        list.remove(list.peekFirst());                 
                    }
                    i++;
                    j++;
                }


        }


        return ans;

    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();

        int[] ans=slidingwindowmax(arr,k);
        for(int i:ans){
            System.out.println(i);
        }
    }
}