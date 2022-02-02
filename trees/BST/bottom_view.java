import java.util.*;
public class bottom_view {
    class Solution
    {
        
        static class Pair{
        Node node;
        int index;
        // int level;
        Pair(){};
        Pair(Node node,int index){
        this.node=node;
        this.index=index;
        // this.level=level;
        }
        }
        //Function to return a list containing the bottom view of the given tree.
        public ArrayList <Integer> bottomView(Node node)
        {
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(node,0));
        Map<Integer,Integer> map=new TreeMap<>();
        while(q.size()>0){
            
        Pair rem=q.remove();
        if(rem.node.left!=null)q.add(new Pair(rem.node.left,rem.index-1));
        if(rem.node.right!=null)q.add(new Pair(rem.node.right,rem.index+1));
         map.put(rem.index,rem.node.data);
        
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
        }
    }    
}
