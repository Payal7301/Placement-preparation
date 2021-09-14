
import java.io.*;
import java.util.*;

public class removenodefrombst {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }


  public static int max(Node node){
      if(node.right!=null){
          return max(node.right);
      }else{
          return node.data;
      }
  }
  public static Node remove(Node node, int data) {
    // if node to be removed is leaf->child0
    
    //if node to be removed has 1 child
    
    // if node to be removed has two child
    if(node==null){
        return null;
    }
    
    if(data<node.data){
        node.left=remove(node.left,data);                   //1.case1->if data is present on left recursively move left
    }
    else if(data>node.data){
        node.right=remove(node.right,data);                   //2.case2->if data is present on right recursively move right
    }else{
        // if node.data==data                                //1.case1->if data is found
        if(node.left==null&&node.right==null){
            node=null;
            return node;                                                //if 0 child
        }else if(node.left!=null&&node.right==null){
            //only has left child
            Node nl=node.left;
            // node=null;
            return nl;                                                //if 1 left child
            
        }else if(node.left==null&&node.right!=null){
            
            Node rn=node.right;                                         //if 1 right child
            return rn;
            
        }else if(node.left!=null&&node.right!=null){
        int maxln=max(node.left);                                       // if 2 child
        node.data=maxln;
        node.left=remove(node.left,maxln);
        return node;
        
        
           
        }
        
        
    }
     return node;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    root = remove(root, data);

    display(root);
  }

}