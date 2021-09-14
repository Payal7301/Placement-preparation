
/*package whatever //do not write package name here */

import java.util.*;

class Minimum_diff_element_in_sorted_array {
    
    public static int Minimum_diff_with_element(int[] arr,int x){
        
        int[] res=Ceil_and_floor(arr,x);
        int ceil=res[0];
        int floor=res[1];
        
        return Math.abs(ceil-x)<Math.abs(floor-x)?ceil:floor;
    }
    
    
    public static int[] Ceil_and_floor(int[] arr,int x){
        
        int[] ans=new int[2];
        int lo=0;
        int hi=arr.length-1;
        
        if(x<arr[lo]){
         ans[0]= arr[lo];
         ans[1]=0;
         return ans;
        }else if(x>arr[hi]){
           ans[0]=arr[hi];
           ans[1]=0;
        }else{
        
        
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(arr[mid]==x){
               ans[0]=arr[mid];
               ans[1]=0;
               return ans;
            }
            
            if(arr[mid]<x){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        
        
        ans[0]=arr[lo];//Ceil
        ans[1]=arr[hi];//Floor
        return ans;
        }
        return ans;
    }
    //  public static int Floor(int[] arr,int x){
    //     int lo=0;
    //     int hi=arr.length-1;
        
    //     while(lo<=hi){
    //         int mid=lo+(hi-lo)/2;
            
    //         if(arr[mid]==x){
    //             return arr[mid];
    //         }
            
    //         if(arr[mid]<x){
    //             lo=mid+1;
    //         }else{
    //             hi=mid-1;
    //         }
    //     }
    //     return arr[hi];
    // }
	public static void main (String[] args) {
// 	minimum difference element in sorted Array
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int[] arr=new int[n];
    
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
    }
    int x=scn.nextInt();
    
    int ans=Minimum_diff_with_element(arr,x);
    System.out.println(ans);
	}
	
	
}