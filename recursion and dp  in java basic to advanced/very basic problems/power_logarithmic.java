package dp;
java.util.*;
public class power_logarithmic {
    public static void main(String[] args) {
        
   
    Scanner scn=new Scanner(System.in);

    int n=scn.nextInt();
    int power=scn.nextInt();
    int ans=power_log(n,power);
    System.out.println(ans);
}
public static int power_log(int n,int power) {

    // base case
    if(power==0){
        return 1;
    }
    if(n%2==0){
    int ans=power_log(n, power/2)*power_log(n, power/2);
    return ans;
}else{
    int ans=power_log(n, power/2)*power_log(n, power/2)*n;
    return ans; 
}
}
}
