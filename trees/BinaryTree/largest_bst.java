
import java.io.*;
import java.util.*;

public class largest_bst {
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
  
  
  static class bstpair{
     int min;
     int max;
     boolean isbst;
    //  node which is largest bst
     Node nwlbst;
    //  size of largest bst found upto this point
     int soflbst;
  }
  
  
  public static bstpair isBst(Node node){
    if(node==null){
        bstpair bp=new bstpair();
        bp.min=Integer.MAX_VALUE;
        bp.max=Integer.MIN_VALUE;
        bp.isbst=true;
        bp.nwlbst=null;
        bp.soflbst=0;
        return bp;


    }
    
    bstpair lp=isBst(node.left);
    bstpair rp=isBst(node.right);
    
    bstpair self=new bstpair();
    self.min=Math.min(node.data,Math.min(lp.min,rp.min));
    self.max=Math.max(node.data,Math.max(lp.max,rp.max));
    self.isbst=(lp.isbst)&&(rp.isbst)&&(node.data>=lp.max&&node.data<=rp.min);
    
    if(self.isbst){
        self.nwlbst=node;
        self.soflbst=lp.soflbst+rp.soflbst+1;
    }
    else if(lp.soflbst>rp.soflbst){
        self.nwlbst=lp.nwlbst;
        self.soflbst=lp.soflbst;
    }else if(rp.soflbst>lp.soflbst){
         self.nwlbst=rp.nwlbst;
        self.soflbst=rp.soflbst;
    }
    
    return self;
    
      
      
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

    Node root = construct(arr);
    bstpair ans=isBst(root);
    System.out.println(ans.nwlbst.data+"@"+ans.soflbst);
    // write your code here
  }

}