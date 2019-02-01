public class ReverseLevelOrderTraversal{
    public ArrayList<Integer> reverseLevelOrderTraversal(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        Queue<Node> q = new LinkeList<>();
        Node curr =  root;
        q.add(curr);
        while(q.size()>0){
            curr = q.poll();
            st.push(curr);
            if(curr.right!=null){
                q.add(curr.right);
            }
            if(curr.left!=null){
                q.add(curr.left);
            }
        }
        while(st.size()>0){
            arr.add(st.pop());
        }
        return arr;
    }
}