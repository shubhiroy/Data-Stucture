import java.util.*;

public class PostorderTreaversalOneStack{
    public ArrayList<Integer> postorderOneStack(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr!=null || st.size()>0){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }else{
                Node temp = st.peek();
                if(temp.right==null){
                    temp = st.pop();
                    arr.add(temp.val);
                    if(temp==st.peek().right){
                        while(st.size()>0 && temp==st.peek().right){
                            temp = st.pop();
                            arr.add(temp.val);
                        }
                    }
                    if(st.size()>0){
                        curr = st.peek().right;
                    }
                }else{
                    curr = temp.right;
                    st.push(curr);
                    curr = curr.left;
                }
            }
        }
        return arr;
    }
}