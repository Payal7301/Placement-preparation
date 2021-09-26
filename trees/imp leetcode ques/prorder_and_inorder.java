
//  * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class preorder_and_inorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
       TreeNode ans=makeTreeRecursively(0,preorder.length-1,preorder,0,inorder.length-1,inorder);
        return ans;
        
    }
    
//     psi->preorder starting index
//     pei->preorder ending indx
//     isi->inorder strting index
//     iei->inorder ending index
    
    
    public static TreeNode makeTreeRecursively(int psi,int pei,int[] preorder,int isi,int iei,int[] inorder){
                            
//     0 1 3 7 8 4 9 10 2 5 11 6
//     7 3 8 1 9 4 10 0 1 5 2  6
        
//         find root
        
        if(psi>pei||isi>iei){
            return null;
        }
//         form node
        TreeNode node=new TreeNode(preorder[psi]);
        
            //     find base
            int idx=isi;
            while(inorder[idx]!=preorder[psi]){
                idx++;
            }
        
       int col=idx-isi;
    
//      get left range and right range
    
        node.left=makeTreeRecursively(psi+1,psi+col,preorder,isi,idx-1,inorder);
        node.right=makeTreeRecursively(psi+col+1,pei,preorder,idx+1,iei,inorder);
        
        
    return node;
        
        
    }
}