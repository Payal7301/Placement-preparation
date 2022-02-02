public class morris_inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
        TreeNode left=curr.left;
        if(left==null){
        ans.add(curr.val);
        curr=curr.right;
        }else{
        TreeNode rchild=getRightChild(left,curr);
        if(rchild.right==null){
        rchild.right=curr;
        curr=curr.left;
        }else{
        rchild.right=null;
        ans.add(curr.val);
        curr=curr.right;
        }
        
        }
        }
        return ans;
        }
        
        
        public static TreeNode getRightChild(TreeNode node,TreeNode curr){
        while(node.right!=null&&node.right!=curr){
            node=node.right;
        }
            
        return node;
        }    
}
