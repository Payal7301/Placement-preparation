import java.util.*;

public class problem5 {
 public static void main(String[] args) {
     Scanner scn=new Scanner(System.in);
     String str=scn.nextLine();
     str=str.replace("+", "");
     char[] arr=str.toCharArray();
     Arrays.sort(arr);
     for(int i=0;i<arr.length-1;i++){
         System.out.print(arr[i]);
         System.out.print("+");
     }
     System.out.print(arr[arr.length-1]);
 }   
}
