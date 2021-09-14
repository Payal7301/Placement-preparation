package dp;
import java.util.*;
public class printinc {
   public static void main(String[] args) {
     Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    System.out.println(" ");
     printinc(n);
   }
   public static void printinc(int n) {
    //    base case
    if(n==0){
        return;
    }
    printinc(n-1);
    System.out.println(n);
    
   }
       
    }
   