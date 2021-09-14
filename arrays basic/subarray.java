/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    private static void Printarray(int[] arr,int i,int j){
        for(int k=i;k<=j;k++){
            // System.out.print("[");
            System.out.print(arr[k]);
            // System.out.print("]");
        }
    }
	public static void main(String[] args) {
// 	print subarrays
int[] arr={1,2,3,4,5};
for(int i=0;i<arr.length;i++){
    for(int j=i;j<arr.length;j++){
        Printarray(arr,i,j);
        System.out.print(" ");
    }
    System.out.println();
}
	}
}
