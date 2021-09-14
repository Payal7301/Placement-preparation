
import java.util.*;

public class zerooneknapsack{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();
        int[] wt=new int[n];
        for(int i=0;i<wt.length;i++){
            wt[i]=scn.nextInt();
        }
        int[] val=new int[n];
        for(int i=0;i<val.length;i++){
            val[i]=scn.nextInt();
        }

        int W=scn.nextInt();
        // knapsack will return max profit from all 
        // 0->profit
        int ans=knapsack(wt,val,W,n);
        System.out.println(ans);

    }


    public static int knapsack(int[] wt,int[] val,int W,int n){

    if(W==0||n==0){
        return 0;
    }

    if(wt[n-1]<=W){
    int profitifnotincl=knapsack(wt,val,W,n-1);
    int profitifinc=val[n-1]+knapsack(wt, val, W-wt[n-1], n-1);

    int maxprofit=Math.max(profitifinc,profitifnotincl);
    return maxprofit;
    }
    else{
        return knapsack(wt, val, W, n-1);
    }



    }
}
