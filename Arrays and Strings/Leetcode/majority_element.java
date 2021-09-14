import java.util.*;
class Solution {
    
    //         using moore voting algorithm 
//         if our array contains a number having n/3 frequency means if we map that element in a groupb of 2 here means if the element exists more than n/3 tim than in the group of three it attaches and after that the element left are the ones that are majority elements
//         example
//         123 145 167 1->1 maps uniquely with every group  means every group has distinct elemnt and the one with high frequency in last is the ans
//         here we have many possiblities
        
        
    public List<Integer> majorityElement(int[] arr) {
        
        if(arr.length==0)return new ArrayList<>();
        int val1=Integer.MIN_VALUE;
        int count1=0;
        int val2=Integer.MAX_VALUE;
        int count2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val1)count1++;
            else if(arr[i]==val2)count2++;
            else if(count1==0){
                val1=arr[i];
                count1=1;
            }else if(count2==0){
                val2=arr[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
            
        }
        
        count1=0;
        count2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val1)count1++;
           else  if(arr[i]==val2)count2++;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(count1>arr.length/3)ans.add(val1);
        if(count2>arr.length/3)ans.add(val2);
        return ans;
        
    }
}