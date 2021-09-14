// generic tree
// formation of generic tree using node class and arraylist
// traversal of generictree using stack with root node
// display of generic tree

import java.io.*;
import java.util.*;
 public class generictreeimplementation{
    static class Node{
        int data;
        ArrayList<Node> children=new ArrayList<>();
        
    }
    private class GenericTree{
        Node root;
    }
    //    1 
    //   /  \
    //  2    3
    
    // 1->2,3,.
    // 2->.
    // 3->.
    
    
    
    // root node passed
    public static void display(Node node){
     // 1->2,3,.
     String st=node.data+"->";
     for(Node child:node.children){
        st+=child.data+",";
     }
     st+=".";
     System.out.println(st);
     
     for(Node child:node.children){
         display(child);
     }
     
    }
    
    public static void main(String[] args){
        int[] arr={1,2,-1,3,-1,-1};
        ArrayDeque<Node> st=new ArrayDeque<>();
        Node root=null;
        for(int i=0;i<arr.length;i++){
            
            if(arr[i]==-1){
                st.pop();
            }else{
            Node n=new Node();
            n.data=arr[i];
            
            if(st.size()>0){
            st.peek().children.add(n);
            st.push(n);
            }else{
                root=n;
                st.push(n);
            }
            }
        }
        display(root);
        
    }
 }