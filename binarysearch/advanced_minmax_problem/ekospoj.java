

 /******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class ekospoj
{
	public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
	int n=scn.nextInt();
	int[] arr=new int[n];
	for(int i=0;i<n;i++){
	    arr[i]=scn.nextInt();
	    
	}
	int kreqd=scn.nextInt();
	int ans=EKO(arr,kreqd);
	System.out.println(ans);
	}
	
	
	public static int EKO(int[] arr,int k){
	    
	    int min=Integer.MAX_VALUE;
	    int max=Integer.MIN_VALUE;
	    for(int i=0;i<arr.length;i++){
	        if(arr[i]>max)max=arr[i];
	        if(arr[i]<min)min=arr[i];
	    }
	    int ans=0;
	    int lo=min;
	   // min height where the blade can be placed->min of the Array
	   int hi=max;
	   //max height where blade can be pplaced-
	   while(lo<=hi){
	       int mid=lo+(hi-lo)/2;
	       
	       if(IsValid(arr,mid)==k){
	           ans=mid;
	           return ans;   
	           
	       }else if(IsValid(arr,mid)>k){
	           
	           lo=mid+1;
	       }
	       
	       else{
	           hi=mid-1;
	       }
	   }
	return ans;  
	}
// 	static int k;
	public static int IsValid(int[] arr,int k){
	    int sum=0;
	    for(int i=0;i<arr.length;i++){
	        
	        if(arr[i]>k){
	            sum+=arr[i]-k;
	        }else{
	            sum+=0;
	        }
	    }
	    
	   // if(sum>=k)return true;
	   // return false;
	   
	   return sum;
	}
}

