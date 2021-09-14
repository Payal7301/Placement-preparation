
import java.util.*;
public  class Main{
    
    
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    // constructor
    public static void display(Node node){
        // print parent first
        
        if(node==null){
            return;
        }
        String str="";
        if(node.left!=null){
        str+=node.left.data;    
        }else{
           str+="."; 
        }
        str+="<-"+node.data+"->";
         if(node.right!=null){
        str+=node.right.data;    
        }else{
           str+="."; 
        }
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
  
    
    public static Node constructor(int[] arr,int lo,int hi){
        
        if(lo>hi){
            return null;
        }
       
        int mid=(lo+hi)/2;
        int root=arr[mid];
        Node lc=constructor(arr,lo,mid-1);
        Node rc=constructor(arr,mid+1,hi);
        
        Node mn=new Node(root,lc,rc);
        return mn;
        
        
    }
    
    public static void main(String[] args){
      int[] arr={12,24,36,72,101,136,190};
      Node root=  constructor(arr,0,arr.length-1);
        display(root);
    }

}