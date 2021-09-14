import java.util.*;

public class longestconsecutivesequence{
    public static void main(String[] args) {
        var scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }

        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],true);
        }

        for(int val:map.keySet()){
            if(map.containsKey(val-1)){
                map.put(val,false);
            }
        }
        int maxcount=0;
        int maxval=0;
        for(int val:map.keySet()){
        int count=1;
        
            if(map.get(val)==true){
                while(map.containsKey(val+1)){
                    count++;
                }
                if(count>maxcount){
                maxcount=count;
                maxval=val;
            }
            }
        }

        for(int i=maxval;i<=maxcount;i++){
            System.out.println(i);
        }
    }
}