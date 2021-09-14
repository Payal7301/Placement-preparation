// problem on interviewbit

public class search_in_bitonic_array {
    public int solve(ArrayList<Integer> A, int B) {
        // find FindPeak
        int peak=FindPeak(A);
        int left=BinarySearchNormal(A,0,peak-1,B);
        int right=ReverseBinrySerach(A,peak,A.size()-1,B);
        

        return left>right?left:right;

    }


    public static int BinarySearchNormal(ArrayList<Integer> arr,int lo,int hi,int x){
        if(lo==hi){
            return lo;
        }
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(x==arr.get(mid)){
                return mid;
            }else if(arr.get(mid)<x){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }

    public static int ReverseBinrySerach(ArrayList<Integer> arr,int lo,int hi,int x){
        if(lo==hi){
            return lo;
        }
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(x==arr.get(mid)){
                return mid;
            }else if(arr.get(mid)<x){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return -1; 
    }
    public static int FindPeak(ArrayList<Integer> arr){
        int lo=0;
        int hi=arr.size()-1;
        if(lo==hi)return lo;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int left=((mid-1)>=0)?arr.get(mid-1):Integer.MIN_VALUE;
            int right=(mid+1<arr.size())?arr.get(mid+1):Integer.MIN_VALUE;
            if(arr.get(mid)>left&&arr.get(mid)>right){
                return mid;
            }else if(right>left){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }

        return lo;
    }
}
