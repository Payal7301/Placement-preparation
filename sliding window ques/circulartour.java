public class circulartour{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] petrol=new int[n];
        for(int i=0;i<petrol.length;i++){
            petrol[i]=scn.nextInt();
        }
        int[] dist=new int[n];
        for(int i=0;i<petrol.length;i++){
            petrol[i]=scn.nextInt();
        }
        boolean ans=getstart(petrol,dist);
        System.out.println(ans);
    }

    public static boolean getstart(int[] petrol,int[] dist){
        
        int surplus=0;
        int diff=0;
        int calc=0;
        for(int i=1;i<=petrol.length;i++){
            calc=petrol[i-1]-dist[i-1];
            if(calc<0){
                diff+=calc;
            }else{
                surplus+=calc;
            }

        }

        if(surplus+diff>=0){
            return true;
        }else{
            return false;
        }
        
    }
}