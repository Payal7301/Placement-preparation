import java.util.*;
public class k_distance_far_graph_approach {

     class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
         }
    class Solution {

    
    
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if(root==null)return new ArrayList<>();
            HashMap<TreeNode,TreeNode> parent=new HashMap<>();
            makeParents(root,parent);
            HashSet<TreeNode> isVisited=new HashSet<>();
            Queue<TreeNode> q=new LinkedList<>();
            int count=0;
            q.add(target);
            while(count!=k){
            int size=q.size();
            while(size-->0){
            TreeNode rem=q.remove();
            isVisited.add(rem);
    //         3 positions to visit
            if(rem.left!=null&&!isVisited.contains(rem.left)){
            q.add(rem.left);
            }
            if(rem.right!=null&&!isVisited.contains(rem.right)){
            q.add(rem.right);
            }
            if(parent.get(rem)!=null&&!isVisited.contains(parent.get(rem))){
            q.add(parent.get(rem));
            }
            
            }
            count++;
            }
            
            List<Integer> ans=new ArrayList<>();
            while(q.size()>0){
                ans.add(q.remove().val);
            }
            return ans;
            
       
        }
        
        public static void makeParents(TreeNode node,HashMap<TreeNode,TreeNode> map){
            
        Queue<TreeNode> q=new LinkedList<>();
        q.add(node);
        map.put(node,null);
        while(q.size()>0){
        TreeNode rem=q.remove();
        if(rem.left!=null){
        map.put(rem.left,rem);
        q.add(rem.left);
        }
            
        if(rem.right!=null){
        map.put(rem.right,rem);
        q.add(rem.right);
        }
        }
        
        }
    }
      
}
