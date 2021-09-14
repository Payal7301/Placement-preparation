public class printincdec {
  public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    System.out.println(" ");
     printincdec(n);

  }  
  public static void printincdec(int n) {
    //   base case
    if(n==0){
        return;
    }
    System.out.println(n);
    printincdec(n-1);
    System.out.println(n);
  }
}
