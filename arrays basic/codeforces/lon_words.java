// package codeforces;

import java.util.*;
public class lon_words {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        // n=n++;
        while(n-->=0){
            String word=scn.nextLine();
            if(word.length()>10){
                String ans="";
                char start=word.charAt(0);
                char end=word.charAt(word.length()-1);
                int length=word.length()-2;
                String intermediate=Integer.toString(length);
                ans=start+intermediate+end;
                System.out.println(ans);
            }else{
                System.out.println(word);

            }
        }
    }
}
