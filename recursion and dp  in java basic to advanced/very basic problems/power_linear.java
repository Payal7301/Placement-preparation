import java.util.Scanner;

public class power_linear {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();
        int power=scn.nextInt();
        int ans=powerlinear(n,power);
        System.out.println(ans);
    }
    public static int powerlinear(int n,int power) {
        // base case
        // n->2(4)=2*2*2*2=2*2(3)
        if(power==0){
            return 1;
        }
        int ans=n*powerlinear(n, power-1);
        return ans;
    }
}
