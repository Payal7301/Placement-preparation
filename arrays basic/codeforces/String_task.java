import java.util.*;
public class String_task {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        str=str.toLowerCase();
        // String ans="";
        Character[] array={'a','A','i','I','e','E','o','O','u','U','y','Y'};
        ArrayList<Character> arr=new ArrayList<>();
        for(char c:array){
            arr.add(c);
        }
        for(int i=0;i<str.length();i++){
            // char ch=;
            if(!arr.contains(str.charAt(i))){
                System.out.print('.');
                System.out.print(str.charAt(i));
            }
        }

            // String str="162160";
            // sytem.out.println(str.toString());

        // System.out.println(ans.toString());
    }
}