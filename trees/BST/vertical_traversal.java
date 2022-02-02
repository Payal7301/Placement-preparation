import java.util.*;
class vertical_traversal {
    
    static class Pair implements Comparable<Pair>{
    TreeNode node;
    int level;
    int axis;
    Pair(){};
    Pair(TreeNode node,int level,int axis){
    this.node=node;
    this.level=level;
    this.axis=axis;
    }
        
    public int compareTo(Pair o){
    
    if(this.axis==o.axis){
    if(this.level==o.level)return this.node.val-o.node.val;
    return this.level-o.level;
    }else{
    return this.axis-o.axis;    
    }    
    
        
    
    // if(this.level==o.level){
    // return this.node.val-o.node.val;
    // }else{
    // return this.axis-o.axis;
    // }
    }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    
    PriorityQueue<Pair> pq=new PriorityQueue<>();
    bfs(root,pq);
        
    List<List<Integer>> ans=new ArrayList<>();
    int y=pq.peek().axis;
    while(pq.size()>0){
    
    List<Integer> temp=new ArrayList<>();
    while(pq.size()>0&&pq.peek().axis==y){
    Pair rem=pq.remove();
    temp.add(rem.node.val);
    }
    y++;
    ans.add(new ArrayList<>(temp));
    }
        
    return ans;
    }
    
    public static void bfs(TreeNode node,PriorityQueue<Pair> pq){
    Queue<Pair> q=new LinkedList<>();
        
    q.add(new Pair(node,0,0));
    while(q.size()>0){
    Pair rem=q.remove();
    pq.add(rem);
    if(rem.node.left!=null)q.add(new Pair(rem.node.left,rem.level+1,rem.axis-1));
    if(rem.node.right!=null)q.add(new Pair(rem.node.right,rem.level+1,rem.axis+1));
    }
    }
}