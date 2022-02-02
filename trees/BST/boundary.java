import java.util.*;
public class boundary {
    
class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	  ArrayList<Integer> ans1=new ArrayList<>();
	 leftWall(node,ans1);
// 	 inorder 
    ArrayList<Integer> leaf=new ArrayList<>();
    inorder(node,leaf);
	 
	 ArrayList<Integer> ans2=new ArrayList<>();
	 rightWall(node.right,ans2);
	 Collections.reverse(ans2);
	 
	 
	 
	ArrayList<Integer> ans=new ArrayList<>();
	ans.addAll(ans1);
	ans.addAll(leaf);
	ans.addAll(ans2);
	 return ans;   
	}
	
	
public static int leftWall(Node node,ArrayList<Integer> ans){
	    
	 
	if(node!=null&&node.left==null&&node.right==null){
// 	  ans.add(node.data);
	  return -1;
	}
	if(node!=null){
	ans.add(node.data);	    
	}

	if(node.left!=null){
	if(leftWall(node.left,ans)==-1)return -1;
	}
    if(node.right!=null){
    if(leftWall(node.right,ans)==-1)return -1;         
    }

	return 0;
	
	
	}
	
	
	public static void inorder(Node node,ArrayList<Integer> ans){
	    if(node==null)return;
	    if(node.left==null&&node.right==null){
	        ans.add(node.data);
	    }
	    
	    inorder(node.left,ans);
	    inorder(node.right,ans);
	}
	
	public static int rightWall(Node node,ArrayList<Integer> ans){
	    
	 if(node==null)return 0;
	if(node!=null&&node.left==null&&node.right==null){
// 	  ans.add(node.data);
	  return -1;
	}
	if(node!=null){
	ans.add(node.data);	    
	}
    if(node.right!=null){
    if(rightWall(node.right,ans)==-1)return -1;         
    }
	if(node.left!=null){
	if(rightWall(node.left,ans)==-1)return -1;
	}
    

	return 0;
	
	
	}
}
