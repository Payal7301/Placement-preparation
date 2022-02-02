import java.util.*;
public class topview {
    class Solution
    {
        
        static class Pair{
        Node node;
        int index;
        Pair(){};
        Pair(Node node,int index){
        this.node=node;
        this.index=index;
        }
        }
        //Function to return a list of nodes visible from the top view 
        //from left to right in Binary Tree.
        static ArrayList<Integer> topView(Node root)
        {
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer> map=new  TreeMap<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        q.add(new Pair(root,0));
        while(q.size()>0){
        Pair rem=q.remove();
        if(rem.node.left!=null)q.add(new Pair(rem.node.left,rem.index-1));
        if(rem.node.right!=null)q.add(new Pair(rem.node.right,rem.index+1));
        min=Math.min(min,rem.index);
        max=Math.min(max,rem.index);
        if(map.containsKey(rem.index))continue;
        
        else map.put(rem.index,rem.node.data);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            ans.add(e.getValue());
        }
        // for(int i=min;i<=max;i++){
        // ans.add(map.get(i));
        // }
        return ans;
        }
    }    
}
