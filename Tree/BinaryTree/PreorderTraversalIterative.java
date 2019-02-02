import java.util.*;

public class PreorderTraversalIterative{
    public ArrayList<Integer> preorderIterative(Node root){
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Node curr = root;
        while(curr!=null || st.size()>0){
            arr.add(curr.val);
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
        }

    }
}