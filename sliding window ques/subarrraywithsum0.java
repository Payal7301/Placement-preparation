import java.util.HashSet;
import java.util.Set;

public class subarrraywithsum0 {
    public static boolean isarraycontainsubarraywithsum0(int[] arr){
        int sum=0;
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            st.add(sum);
            sum+=arr[i];
            if(st.contains(sum)){
                return true;
            }
        }
        return false;
    }
public static void main(String[] args){
Scanner scn=new Scanner(System.in);
int n=scn.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<arr.length;i++){
        arr[i]=scn.nextInt();

    }
    boolean ans=isarraycontainsubarraywithsum0(arr);
    System.out.println(ans);

}    
}
