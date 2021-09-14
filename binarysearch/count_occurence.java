/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class count_occurence
{
    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target=scn.nextInt();

        int ans = CountOccurence(arr,target);
        
        System.out.println(ans);
    }
    
    
    public static int CountOccurence(int[] arr ,int x){
        int first=GetFirst(arr,x);
        int last= GetLast(arr,x);
        
        return (last-first+1)>0?(last-first+1):0;
    }
    
    public static int GetFirst(int[] arr,int x){
        int lo=0;
        int hi=arr.length-1;
        int ans=0;
        if(x>arr[hi]||x<arr[lo])return -1;
        
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(arr[mid]>=x){
            ans=mid;
            hi=mid-1;
                
            }else {
                lo=mid+1;
            }
            
        }
        return ans;
    }
    
    
    public static int GetLast(int[] arr,int x){
        int lo=0;
        int hi=arr.length-1;
        int ans=0;
        if(x>arr[hi]||x<arr[lo])return -1;
        
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(arr[mid]<=x){
            ans=mid;
            lo=mid+1;
                
            }else {
                hi=mid-1;
            }
            
        }
        return ans;
    }
}
		
// 		count occurence of element in array is->last occ-fisrt occ +1;

   
