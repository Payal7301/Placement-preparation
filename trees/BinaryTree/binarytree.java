import java.util.*;

public class binarytree{
    
     public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        } 
    }
    public static class Pair{
        Node node;
        int state;
        public Pair(Node node ,int state){
            this.node=node;
            this.state=state;
        }
    }
    public static void construct(Node root,Integer[] arr){
        // Node rootnode
        ArrayDeque<Pair> st=new ArrayDeque<>();
        st.push(new Pair(root,1));
        int index=1;
        while(st.size()>0){

            Pair peekpair=st.peek();
            if(peekpair.state==1){

                if(arr[index]!=null){
                Node tobepushednode=new Node(arr[index],null,null);//node banao
               peekpair.node.left=tobepushednode;//left pe lagao
                Pair topush=new Pair(tobepushednode,1);//pair banao
                st.push(topush);//stack me push kro
            }else{
                peekpair.node.left=null;//agar left mein kuch nhi h to set it to null
            }
            peekpair.state++;
            index++;
            }
            else if(peekpair.state==2){
                if(arr[index]!=null){
                    Node tobepushednode=new Node(arr[index],null,null);//node banao
                    peekpair.node.right=tobepushednode;//right pe lagao
                    Pair topush=new Pair(tobepushednode,1);//pair banao
                    st.push(topush);
                   
                    
                }else{
                    peekpair.node.right=null;
                }
                peekpair.state++;
                index++;
            }else{
                st.pop();
            }
        }
    }
    public static void display(Node node){
        // base case
        if(node==null){
            return;
        } 

        // print self
        String str="";
        if(node.left==null){
            str+="?";
        }else{
            str+=node.left.data;
         }
         str+="<-"+node.data+"->";
         if(node.right==null){
             str+="?";
         }
         else{
             str+=node.right.data;
         }
         System.out.println(str);
        display(node.left);
        display(node.right);

    }


    public static void main(String[] args){
        Integer[] arr={0,1,3,null,null,4,5,null,null,null,2,6,8,null,null,null,7,null,null};
        Node root=new Node(arr[0],null,null);

        construct(root,arr);
        display(root);
    }
}