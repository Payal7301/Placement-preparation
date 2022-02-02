import java.util.*;
public class left_view {
    class Tree
    {
        //Function to return list containing elements of left view of binary tree.
        ArrayList<Integer> leftView(Node node)
        {

            // method 1
          ArrayList<Integer> ans=new ArrayList<>();
            Map<Integer,Integer> map=new TreeMap<>();
            // ans.add(node.data);
            solver(node,0,map);
            
            
            for(Map.Entry<Integer,Integer> e:map.entrySet()){
            ans.add(e.getValue());
            }
            return ans;

        // method 2
        // ArrayList<Integer> ans=new ArrayList<>();
        // Queue<Node> q=new LinkedList<>();
        // q.add(node);
        // ans.add(node.data);
    
        // while(q.size()>0){
        // int size=q.size();
        // while(size-->0){
        // Node rem=q.remove();
        //  if(rem.left!=null)q.add(rem.left);
        //  if(rem.right!=null)q.add(rem.right);
        // }
        // if(q.peek()!=null){
        // ans.add(q.peek().data);
        // }
        // }
        // return ans;
        }
        
        public static void solver(Node node,int level,Map<Integer,Integer> map){
            
            if(node==null)return;
            if(!map.containsKey(level))map.put(level,node.data);
                
           
            solver(node.left,level+1,map);
             solver(node.right,level+1,map);
            
            }
    }  
}
