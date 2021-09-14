// book allocation problem
// roti prata problem


// 1.book allocation

// there are n books given with some number of pages and we have to distribute these books to k people
// 

import java.util.*;
class book_allocation{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        
        // input  number of books
        int n=scn.nextInt();
        // input books  with pages
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        
        int k=scn.nextInt();
        // input students
        int ans=BookAllocation(arr,k);
        
        System.out.println(ans);
        
    }
    
    public static int BookAllocation(int[] arr,int k){
    
    // range
    
    int min=Integer.MAX_VALUE;
    int sum=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]<min)min=arr[i];
        sum+=arr[i];
    }
    // minimum number of pages that can be allocated
    int ans=0;
    int lo=min;
    // max number of pages that can be alloacted
    int hi=sum;
    
    while(lo<=hi){
        int mid=lo+(hi-lo)/2;
        
        if(IsAns(arr,mid,k)){
            ans=mid;
            hi=mid-1;
        }else{
            lo=mid+1;
        }
    }
    
    return ans;
    }
    
    public static boolean IsAns(int[] arr,int maxpages,int st){
        // is stidents that are assigned books are not excedding
        
        int count=1;
        int tpages=0;
        for(int i=0;i<arr.length;i++){
        // while we reach the maximum number of pages keep adding
        // and when we reach max number of pages decrese this amout and make new tpages to thisamount and add children
       
        if(tpages+arr[i]>maxpages){
            count++;
            tpages=arr[i];
        }else{
             tpages+=arr[i];
        }
        }
        
        return count>st?false:true;
    }
}
