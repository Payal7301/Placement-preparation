import java.util.HashMap;
import java.util.Scanner;

public class longest_substring_with_non_repeating_unique_characters{

public static void main(String[] args){
Scanner scn=new Scanner(System.in);
String s=scn.nextLine();
int ans=getmaxlength(s);
System.out.println(ans);
    
}
public static int getmaxlength(String s){
    int maxsize=0;
    int i=0;
    int j=0;
    HashMap<Character,Integer> mp=new HashMap<>();

    while(j<s.length()){
    
        // basic calculation
        char c=s.charAt(j);
        if(mp.containsKey(c)){
            mp.put(c, mp.get(c)+1);
        }else{
            mp.put(c,1);
        }

        if(mp.size()==j-i+1){
            maxsize=Math.max(maxsize,j-i+1);
            j++;
        }
        else if(mp.size()>j-i+1){

            char c=s.charAt(i);
            mp.put(c,mp.get(c)-1);
            if(mp.get(c)==0){
                mp.remove(c);
            }
            i++;
        }
        j++;
    }
    return maxsize;
}

}