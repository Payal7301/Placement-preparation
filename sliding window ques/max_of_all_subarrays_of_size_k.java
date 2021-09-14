import java.util.*;

public class max_of_all_subarrays_of_size_k {
    public static ArrayList<Integer> getarrayofmaxofsubarrayofsizek(int[] arr,int k){

        ArrayDeque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer> ans=new ArrayList<>();

        int i=0;
        int j=1;                                                                                                                                                                                                                                                                                                                                
        q.push(arr[j]);
        while(j<arr.length){
            if(arr[j]>q.peekFirst()){
                while(!q.isEmpty()){
               q.removeLast(); 
            }
            }
            q.add(arr[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                ans.add(q.peekFirst());
                if(arr[i]==q.peekFirst()){
                    q.pollFirst();
                    
                }
                i++;
                j++;
            }
        }

        
    
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
        ArrayList<Integer> ans=getarrayofmaxofsubarrayofsizek(arr,k);
        for(int e:ans){
            System.out.println(e);
        }
    }
}
