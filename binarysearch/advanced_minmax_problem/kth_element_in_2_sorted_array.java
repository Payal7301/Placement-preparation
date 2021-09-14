public class kth_element_in_2_sorted_array {
    class Solution {
        public long kthElement( int nums1[], int nums2[], int n, int m, int k) {
            
            // equal parttition until we get k number of elements
            // parttition  
            // if(k==1)return Math.min(nums1[0],nums2[0]);
            // if(k>=1&&k<=nums1.length+nums2.length){
            if(nums1.length>nums2.length)return kthElement(nums2,nums1,m,n,k);
            int lo=Math.max(0,k-m);
            int hi=Math.min(k,n);
            
            while(lo<=hi){
                int cut1=lo+(hi-lo)/2;
                // cut2 decide to take how many numbers
                int cut2=k-cut1;
                // since we need to get sorted array both side we need to look the same condition
                // int ul= nums1[cut1-1];
                // // int ur=cut1<nums1.length?nums1[cut1]:Integer.MAX_VALUE;
                // int ur=nums1[cut1];
                // int bl=nums2[cut2-1];
                // // int br=cut2<nums2.length?nums2[cut2]:Integer.MAX_VALUE;
                // int br=nums2[cut2];
                int ul=cut1-1==0?Integer.MIN_VALUE:nums1[cut1-1];
                int ur=cut1==nums1.length?Integer.MAX_VALUE:nums1[cut1];
                int bl=cut2-1==0?Integer.MIN_VALUE:nums2[cut2-1];
                int br=cut2==nums2.length?Integer.MAX_VALUE:nums2[cut2];
                if(ul<=br&&bl<=ur){
                    return Math.max(ul,bl);
                }
                else if(ul>br){
                    // increase barray
                    hi=cut1-1;
                }else if(bl>ur){
                    // increase a array
                    lo=cut1+1;
                }
            }
            
           
        // }
         return -1;
    }
    }
}
