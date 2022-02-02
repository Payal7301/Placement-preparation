import java.util.*;
public class right_view {

    class Solution{
        //Function to return list containing elements of right view of binary tree.
        ArrayList<Integer> rightView(Node node) {
        // ArrayList<Integer> ans=new ArrayList<>();
        // Map<Integer,Integer> map=new TreeMap<>();
        // // ans.add(node.data);
        // solver(node,0,map);
        
        
        // for(Map.Entry<Integer,Integer> e:map.entrySet()){
        // ans.add(e.getValue());
        // }
        // return ans;

        // OR 
        // ans using Queue
        ArrayList<Integer> ans=new ArrayList<>();
            Queue<Node> q=new LinkedList<>();
            q.add(node);
            ans.add(node.data);
        
            while(q.size()>0){
            int size=q.size();
            while(size-->0){
            Node rem=q.remove();
           
            if(rem.right!=null)q.add(rem.right);
             if(rem.left!=null)q.add(rem.left);
            }
            if(q.peek()!=null){
            ans.add(q.peek().data);
            }
            }
            return ans;


        }
        
        public static void solver(Node node,int level,Map<Integer,Integer> map){
        
        if(node==null)return;
        if(!map.containsKey(level))map.put(level,node.data);
            
        solver(node.right,level+1,map);
        solver(node.left,level+1,map);
        
        }

        
    }
}
