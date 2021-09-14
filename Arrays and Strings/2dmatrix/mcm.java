import java.util.*;

public class mcm {


    public static int[][] MCM(int[][] a,int[][] b){
        int r1=a.length;
        int c1=a[0].length;
        int r2=b.length;
        int c2=b[0].length;
        int[][] c=new int[r1][c2];
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++ ){
                c[i][j]=0;
                for(int k=0;k<c1;k++ ){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
public static void main(String[] args){
    Scanner scn=new Scanner(System.in);
    int r1=scn.nextInt();
    int c1=scn.nextInt();
    int r2=scn.nextInt();
    int c2=scn.nextInt();

    int[][] a=new int[r1][c1];
    int[][] b=new int[r2][c2];
    if(c1!=r2){
        System.out.println(-1);
        return ;
    }

    for(int i=0;i<r1;i++){
        for(int j=0;j<c1;j++){
            a[i][j]=scn.nextInt();

        }
    }
 for(int i=0;i<r2;i++){
        for(int j=0;j<c2;j++){
            b[i][j]=scn.nextInt();
            
        }
    }
    int[][] ans=MCM(a,b);
    for(int i=0;i<ans.length;i++){
        for(int j=0;j<ans[0].length;j++){
            System.out.print(ans[i][j]+" ");
            
        }
        System.out.println();
    }
}
}
