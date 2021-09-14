import java.io.*;
import java.util.*;



public class count_anagrams {
    public static int countanagrams(String s,String pat){

        int ans=0;
        // sliding window problem
        int i=0;
        int j=0;
        int k=pat.length();
        Map<Character,Integer> mp=new HashMap<>();
        
		for(int m=0;m<k;m++){
		    char c = pat.charAt(m);

		    if(mp.containsKey(c))
		    {
		        mp.put(c,mp.get(c)+1);
		    }
		    else{
		    mp.put(c,1);
		    }
		}
        int count=mp.size();
        while(j<s.length()){
            // 1.basic claculation as j proceeds
            char alphabet=s.charAt(j);
            if(mp.containsKey(alphabet)){
                mp.put(alphabet, mp.get(alphabet)-1);
                if(mp.get(alphabet)==0){
                    count--;
                }
            }
            // if j-i+1<k
            if(j-i+1<k){
                j++;
            }
            // 3.calculate ans from basic calculation and slide the window
            if(count==0){
                ans++;
            }    
            
            }
            // slide the window
            if(mp.containsKey(alphabet)){
                mp.put(alphabet,mp.get(alphabet)+1);
                if(mp.get(alphabet)==1){
                    count++;
                }
            }
            i++;
            j++;

        }
           

        }


        

    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String s=scn.next();
        String pat=scn.next();
        int ans=countanagrams(s,pat);
        System.out.println(ans);
    }
}
