
// Online IDE - Code Editor, Compiler, Interpreter
// greatest element on left
import java.io.*;
import java.util.*;


public class Main
{
    public static int[] greatestelementonleft(int[] arr){
        int[] gel=new int[arr.length];
        Stack<Integer> st=new Stack<>();
       
        for(int i=0;i<arr.length;i++){
            if(st.size()==0){
                gel[i]=-1;
            }else if(arr[st.peek()]>arr[i]){
                gel[i]=st.peek();
            }
            else{
                while(st.size()>0 && arr[st.peek()]<=arr[i]){
                    st.pop();
                }
             if(st.size()==0){
                gel[i]=-1;
            }else if(arr[st.peek()]>arr[i]){
                gel[i]=st.peek();
            }   
            }
           st.push(i); 
        }
        return gel;
    }
    public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<arr.length;i++){
        arr[i]=scn.nextInt();
    }
    int[] gel=greatestelementonleft(arr);
    System.out.println(" ");
    int[] answer=new int[arr.length];
   for(int i=0;i<arr.length;i++){
       answer[i]=i-gel[i];
   }
   for(int i=0;i<arr.length;i++){
    System.out.println(answer[i]);
   }
   
    }
}
