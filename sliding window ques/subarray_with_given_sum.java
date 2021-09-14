import java.util.ArrayList;
import java.util.Scanner;

public class subarray_with_given_sum {

public static ArrayList<Integer> getarrayidxwithsumk(int[] arr,int k){
    ArrayList<Integer> ans=new ArrayList<>();
    int i=0;
    int j=0;
    int sum=0;
    while(j<arr.length){
        sum+=arr[j];

        if(sum<k){
            j++;
        }
        else if(sum>k){
            while(sum>k){
            sum=sum-arr[i];
            i++;
            }
            if(sum==k){
                ans.add(i+1);
                ans.add(j+1);
                return ans;
            }else{
                j++;
            }
        }

        if(sum==k){
            ans.add(i+1);
            ans.add(j+1);
            return ans;
        }
    }
    ans.add(-1);
    return ans;
}
    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<arr.length;i++){
        arr[i]=scn.nextInt();

    }

    int k=scn.nextInt();
    ArrayList<Integer> ans=getarrayidxwithsumk(arr,k);
    for(int e:ans){
        System.out.print(e);
    }
   } 
}
