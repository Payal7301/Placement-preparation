import java.util.*;
public class koko_eating_banana {


    // input array and h hours
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        // input n
        // input arr
        // input h hours
        
    }
    public int minEatingSpeed(int[] arr, int h) {
        //         
                int max=Integer.MIN_VALUE;
                for(int i=0;i<arr.length;i++){
                    if(arr[i]>max)max=arr[i];
                }
                int lo=1;
                int hi=max;
                int ans=-1;
                while(lo<=hi){
                    
                    int mid=lo+(hi-lo)/2;
                    boolean myans=KokoEatsUnderRange(arr,mid,h);
                    if(myans==true){
                        ans=mid;
                        hi=mid-1;
                    }
                    else if(myans==false){
                        lo=mid+1;
                    }
                }
                
                return ans;
            }
            
            public static boolean KokoEatsUnderRange(int[] arr,int mid,int h){
        //         if koko eats under h hours true else false
                int th=0;
                
                for(int i=0;i<arr.length;i++){
                    if(arr[i]>mid){
        //                 bananas are exceeding the limit per hours
                        
                        th+=(int)Math.ceil(arr[i]*1.0/mid);
                        
                    }else{
                        th++;
                    }
                    
                   
                }
                return th>h?false:true;
                
            }
}
