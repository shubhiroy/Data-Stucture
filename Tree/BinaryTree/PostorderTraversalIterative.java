import java.util.*;

public class PostorderTraversalIterative{
    public ArrayList<Integer> postorderIterative(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node curr = root;
        st.push(curr);
        while(curr!=null && st1.size()>0){
            curr = st1.pop();
            if(curr.left!=null){
                st1.push(curr.left);
            }
            if(curr.right!=null){
                st1.push(curr.right);
            }
            st2.push(curr);
        }
        while(st2.size()>0){
            curr = st2.pop();
            arr.add(curr.val);
        }
        return arr;
    }
}