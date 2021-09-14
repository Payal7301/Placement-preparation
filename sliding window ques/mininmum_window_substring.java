/*
import java.io.*;
import java.util.*;

public class mininmum_window_substring{

    public static int getminimumrequiredsubstring(String s1,String s2){


        int i=0;
        int j=0;
        int mn=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        int k=0;//for storing values of s2 in map
        while(k<s2.length()){
            char c=s2.charAt(k);
            if(mp.containsKey(c)){
                mp.put(c,mp.get(c)+1);
            }else{
                mp.put(c,1);
            }
        }
        int count=mp.size();

        while(j<s1.length()){
            // as j moves in s1 
            char ch=s1.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0){
                    count--;
                }  
            }
            
            if(count>0){
                j++;
            }
            else if(count==0){
                // firstly optimize the candidate obtained
                char s=s1.charAt(i);
                if(mp.containsKey(s)){
                    if(mp.get(s)<0)}{
                        mp.put(s,mp.get(s)+1);
                        i++;
                    }
                }else{
                    i++;
                }
            
                mn=Math.min(mn,j-i+1);
                j++;
            }
      }
        return mn;
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String s1=scn.nextLine();
        String s2=scn.nextLine();
        scn.close();
        int ans=getmnimumrequiredsubstring(s1,s2);
        System.out.println(ans);
    }
}
*/

import java.util.*;
public class mininmum_window_substring
{
    public static String getminstringwhichcontainsp(String s,String p){
        HashMap<Character,Integer> mp=new HashMap<>();
        // for string p
        for(int i=0;i<p.length();i++){
        char c=p.charAt(i);
        if(mp.containsKey(c)){
            mp.put(c,mp.get(c)+1);
        }else{
            mp.put(c,1);
        }
        }

        int count=mp.size();
        int i=0;
        int j=0;
        int length=Integer.MAX_VALUE;
        while(j<s.length()){
            char v=s.charAt(j);
            if(mp.containsKey(v)){
                mp.put(v,mp.get(v)-1);
                if(mp.get(v)==0){
                    count--;
                }

            }
            if(count>0){
                j++;
            }
            else if(count==0){
                while(count==0){
                String potentialans=s.substring(i,j);
                if(potentialans.length()<length){
                    length=potentialans.length;
                    ans=s.substring(i,j+1);
                    
                }
                    if(mp.containsKey(s.charAt(i))){
                        mp.put(s.charAt(i),mp.get(s.charAt(i)+1));
                        if(mp.get(s.charAt(i)>0)){
                            count++;
                        }
                    }
                    i++;
                }
                j++;
                
            }


        }
        return ans;
    }
	public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    String s=scn.nextLine();
    String p=scn.nextLine();
    String ans=getminstringwhichcontainsp(s,p);
    System.out.println(ans);
	}
}