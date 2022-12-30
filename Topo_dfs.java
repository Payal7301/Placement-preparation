import java.util.*;

public class Topo_dfs {
 
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
    int[] ans=new int[V];
    boolean[] isVisited=new boolean[V];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<V;i++){
    if(!isVisited[i]){
    dfs(i,isVisited,adj,st);
    }
    }
    
    int i=0;
    while(st.size()>0){
    ans[i++]=st.pop();
    }
    return ans;
    
    }
    
    public static void dfs(int i,boolean[] isVisited,ArrayList<ArrayList<Integer>> arr,Stack<Integer> st){
    isVisited[i]=true;
    for(int val:arr.get(i)){
    if(!isVisited[val])dfs(val,isVisited,arr,st);
    }
    
    st.push(i);
    }
}
   
