
import java.io.*;
import java.util.*;

public class target_sum_pair_using_arraytsp {
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



  static class ItPair{
      Node node;
      int state;
      ItPair(Node node,int state){
          this.node=node;
          this.state=state;
      }
  }
  
  public static Node ItrInorder(ArrayDeque<ItPair> leftst){
      while(leftst.size()>0){
          ItPair peek=leftst.peek();
          if(peek.state==0){
            if(peek.node.left!=null){
                leftst.push(new ItPair(peek.node.left,0));
            }
            peek.state++;
          }else if(peek.state==1){
            //   we are in inorder
              if(peek.node.right!=null){
                leftst.push(new ItPair(peek.node.right,0));
            }
            peek.state++;
            return peek.node;
          }else{
            //   state ->2
            leftst.pop();
          }
      }
      return null;
  }
  
    public static Node ItrInorderReverse(ArrayDeque<ItPair> rightst){
      while(rightst.size()>0){
          ItPair peek=rightst.peek();
          if(peek.state==0){
            if(peek.node.right!=null){
                rightst.push(new ItPair(peek.node.right,0));
            }
            peek.state++;
          }else if(peek.state==1){
            //   we are in inorder
              if(peek.node.left!=null){
                rightst.push(new ItPair(peek.node.left,0));
            }
            peek.state++;
            return peek.node;
          }else{
            //   state ->2
            rightst.pop();
          }
      }
      return null;
  }
  
  
  public static void TargetSumPair(Node node,int data){
    //   use itr inorder for i
    //   use itr inorderreverse for j
    ArrayDeque<ItPair> leftst=new ArrayDeque<>();
    ArrayDeque<ItPair> rightst=new ArrayDeque<>();
    leftst.push(new ItPair(node,0));
    rightst.push(new ItPair(node,0));
    
    Node i=ItrInorder(leftst);
    Node j=ItrInorderReverse(rightst);
    
    while(i.data<j.data){
        if(i.data+j.data<data){
            i=ItrInorder(leftst);
        }else if(i.data+j.data>data){
            j=ItrInorderReverse(rightst);
        }else{
            System.out.println(i.data+" "+j.data);
            i=ItrInorder(leftst); 
            j=ItrInorderReverse(rightst);
        }
    }
    
      
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
    TargetSumPair(root,data);
  }

}