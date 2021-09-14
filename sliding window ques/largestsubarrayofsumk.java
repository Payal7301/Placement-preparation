import java.util.Scanner;

// Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.

// For Input:
// 1
// 7 5
// 4 1 1 1 2 3 5
// your output is: 
// 4
public class largestsubarrayofsumk {

    public static int largest_subarray_of_sum(int[] arr,int k){
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=0;
        int sum=0;
        while(j<arr.length){
            // basic calculation
            sum=sum+arr[j];

            
           if(sum==k){
                max=Math.max(max,j-i+1);
                j++;
            }
            else if(sum<k){
                j++;
            }else if(sum>k){
                while(sum>=k){
                sum=sum-arr[i];
                i++;
            }
            j++;
            }
            

        }


        return max;

    }
   public static void main(String[] args){
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<arr.length;i++){
        arr[i]=scn.nextInt();
    }
    int k=scn.nextInt();
    int ans=largest_subarray_of_sum(arr,k);
    System.out.println(ans);
   } 
}
