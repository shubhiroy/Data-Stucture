import java.util.*;

public class InorderTraversalIterative{
    public ArrayList<Integer> inorderIterative(Node root){
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr!=null || st.size()>0){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            arr.add(curr.val);
            curr = curr.right;
        }
    }
}