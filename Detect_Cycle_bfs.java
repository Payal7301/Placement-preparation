// idea is that we can visit the unvisited node and if there visited node then this 
// should be our parent if no that means it is visited by any other node


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
    int[] parent=new int[V]; 
    boolean[] vis=new boolean[V];
    Arrays.fill(parent,-1);
    for(int i=0;i<V;i++){
    if(vis[i]==false&&bfs(i,adj,parent,vis))return true;
    }
    return false;
        
    }
    public boolean bfs(int i,ArrayList<ArrayList<Integer>> adj,int[] parent,boolean[] vis){
    Queue<Integer> q=new LinkedList<>();
    
    parent[i]=i;
    vis[i]=true;
    q.add(i);
    while(q.size()>0){
    int rem=q.remove();
    int myparent=parent[rem];
    for(int val:adj.get(rem)){
    if(val!=myparent){
    if(vis[val]==true)return true;
    vis[val]=true;
    parent[val]=rem;
    q.add(val);
    }
    }
    }
    
    
    return false;
    
           
    }
}
   