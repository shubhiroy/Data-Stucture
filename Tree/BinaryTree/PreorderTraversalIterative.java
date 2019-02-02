import java.util.*;

public class PreorderTraversalIterative{
    public ArrayList<Integer> preorderIterative(Node root){
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Node curr = root;
        while(curr!=null || st.size()>0){
            while(curr!=null){
                arr.add(curr.val);
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            curr = curr.right;
        }
        return arr;
    }
}