public class factorial {
   public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int ans=factorial(n);
    System.out.println(ans);
   } 

   public static void factorial(int n) {
       
    // ex->5!=5*4*3*2*1
// base case
if(n==1){
    return 1;
}
int ans=n*factorial(n-1);
return ans;
   }

}
