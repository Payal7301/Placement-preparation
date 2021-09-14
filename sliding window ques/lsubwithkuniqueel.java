import java.io.*;
import java.util.*;

public class lsubwithkuniqueel{

    public static int get_max_length_of_k_unique_chararcters(String s,int k){
    int max=0;
    Map<Character,Integer> mp=new HashMap<>();
    int i=0;
    int j=0;
    while(j<s.length()){
        // basic claculation is to store s.charAt(j ) to Hashmap
        char c=s.charAt(j);
        if(mp.containsKey(c))
		    {
		        mp.put(c,mp.get(c)+1);
		    }
		    else{
		    mp.put(c,1);
		    }
        
        // as the element is stored into hashmap now we have to look on our conditions
        if(mp.size()<k){
            j++;
        }

        if(mp.size()==k){
            max=Math.max(max,j-i+1);
            j++;
        }
        if(mp.size()>k){
            while(mp.size()>k){
                 mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                
                if(mp.get(s.charAt(i))==0){
                    mp.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }

    }
     return max;
    }
    public static void main(String[] args){
    Scanner scn=new Scanner(System.in);
    String s=scn.nextLine();
    int k=scn.nextInt();
    int maxlength=get_max_length_of_k_unique_chararcters(s,k);
    System.out.println(maxlength);

    }
}

// k largest element
