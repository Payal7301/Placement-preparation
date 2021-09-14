import java.util.*;

public class problem4 {
   public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
       String s1=sc.nextLine();
       String s2=sc.nextLine();
        String ns1=s1.toLowerCase();
        String ns2=s2.toLowerCase();
        int ans=ns1.compareTo(ns2);
       if(ans==0){
           System.out.println("0");
       }else{
           int i=0;
        while(i<ns1.length()){
            char c1=ns1.charAt(i);
            char c2=ns2.charAt(i);

            if(c1<c2){
                System.out.println("-1");
                break;
            }
             if(c1>c2){
                
                System.out.println("1");
                break;
            }else{
                i++;
            }
        }

       }
   } 
       
}
