
import java.util.*;
public class ceil
{
    
    public static int ceilInSortedArray(int[] arr,int x){
        
        int lo=0;
        int hi=arr.length-1;
        
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(arr[mid]==x){
                return arr[mid];   
            }
            
            if(arr[mid]>=x){
                hi=mid-1;
            }else{
                lo=mid+1;
                
            }
        }
        return  lo;
        
    }
	public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
	
	int n=scn.nextInt();
	int[] arr=new int[n];
	for(int i=0;i<arr.length;i++){
	    arr[i]=scn.nextInt();
	}
	
	int x=scn.nextInt();
// 	find ceil of an element 
    int ans=ceilInSortedArray(arr,x);
    System.out.println(ans);
	}
}
