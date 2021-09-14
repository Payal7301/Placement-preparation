
import java.util.*;
import java.io.*;


public class firstnegative{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();
        ArrayList<Integer> ans=firstnegativeinarr(arr,k);
        System.out.println(ans);
    }

    public static ArrayList<Integer> firstnegativeinarr(int[] arr,int k){
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        LinkedList<Integer> ll=new LinkedList<>();
        while(j<arr.length){
            // starting calculation ->formation of linkedlist which contain ans
            if(arr[j]<0){
                ll.add(arr[i]);
            }
            // 
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                // calculate ans
                if(ll.size()==0){
                    ans.add(0);
                }else{
                    ans.add(ll.peek());
                    if(arr[i]==ll.peek()){
                        ll.remove();
                    }
                    i++;
                    j++;

                }
            }
        }

        return ans;
    }
}