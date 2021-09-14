public class painters_partition_problem {
    class Solution{
        static long minTime(int[] arr,int n,int k){
       
         long sum=0;
         long max=Integer.MIN_VALUE;
         for(int i=0;i<arr.length;i++){
             if(arr[i]>max)max=arr[i];
             sum+=arr[i];
         }
         long ans=0;
           long lo=max;
         long hi=sum;
         
         while(lo<=hi){
             long mid=lo+(hi-lo)/2;
             if(mid<max)lo=mid+1;
             if(IsPossibleToPaintWithKPainters(arr,mid)<=k){
                 ans=mid;
                 hi=mid-1;
             }else{
                 lo=mid+1;
             }
             
             
         }
         
         return ans;
        }
        
        public static long IsPossibleToPaintWithKPainters(int[] arr,long mid){
            
            long count=1;
            long sum=0;
            for(int i=0;i<arr.length;i++){
                if(sum+arr[i]>mid){
                    count++;
                    sum=arr[i];
                }else{
                    sum+=arr[i];
                }
                
                
            }
            return count;
            
        }
    }
}
