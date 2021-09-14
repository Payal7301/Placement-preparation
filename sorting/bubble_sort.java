import java.util.*;
public class bubble_sort{
    public static void main(String[] args){
    
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }

        bubbleSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
   public static void bubbleSort(int[] arr){

// n-1 iteration
for(int i=1;i<=arr.length-1;i++){
    for(int j=0;j<arr.length-i;j++){
        if(arr[j]>arr[j+1]){
            swap(arr,j,j+1);
        }
    }
}

    }
}