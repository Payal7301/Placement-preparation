import java.util.HashMap;
import java.util.Map;

public class count_distinct_elements {

    public  static int[] get_count_of_distinct_elements(int[] arr,int k){
        int i=0;
        int j=0;
        Map<Integer,Integer> mp=new HashMap<>();
        int[] ans=new int[arr.length-k+1];
        while(j<arr.length){
            // basic calculation
            int key=arr[j];
            if(mp.containsKey(key)){
                mp.put(key,mp.get(key)+1);
            }else{
                mp.put(key,1);
            }

            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                ans[i]=mp.size();
                int value=arr[i];
                mp.put(value,mp.get(value)-1);
                if(mp.get(value)==0){
                    mp.remove(value);
                }
                i++;
                j++;
            }
            return ans;


        }
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();
        int[] ans=get_count_of_distinct_elements(arr,k);
        for(int e:ans){
            System.out.println(e);
        }
    }

}
