public class iterative_inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)return new ArrayList<>();
        
        List<Integer> ans=new ArrayList<>();
        HashSet<TreeNode> set=new HashSet<>();
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(st.size()>0){
        while(st.peek().left!=null&&!set.contains(st.peek().left))st.push(st.peek().left);
        TreeNode node=st.pop();
        set.add(node);
        ans.add(node.val);
        if(node.right!=null&&!set.contains(node.right))st.push(node.right);
        }
            
        return ans;
        
        }   
}
