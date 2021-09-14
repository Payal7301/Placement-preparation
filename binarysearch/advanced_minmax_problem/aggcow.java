import java.util.*;

public class aggcow
{
	public static void main(String[] args) {
// 	n Number of stall
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<arr.length;i++){
        arr[i]=scn.nextInt();
        
    }
    
    int k=scn.nextInt();
    Arrays.sort(arr);
    int ans=AggCow(arr,k);
    System.out.println(ans);
	}
	
	public static int AggCow(int[] arr,int k){
	   // we need to find the largest minimum distance for k kcows
	   int lo=1;
	   //if cows are placed with distance 1
	   int hi=arr[arr.length-1]-arr[0];
	   int ans=0;
	   while(lo<=hi){
	       int mid=lo+(hi-lo)/2;
	       
	       if(CanPlaceCow(arr,k,mid)){
	           //means we can place cow here than we need to find last true 
	           ans=mid;
	           lo=mid+1;
	       }else{
	           hi=mid-1;
	       }
	   }
	   return ans;
	}
	
	
	public static boolean CanPlaceCow(int[] arr,int cows,int mid){
	    int count=1;
	    int place=0;
	    for(int i=1;i<arr.length;i++){
	        if(arr[i]-arr[place]>=mid){
	            count++;
	            place=i;
	        }
	        
	        if(count==cows)return true;
	    }
	    return false;
	    
	}
}
