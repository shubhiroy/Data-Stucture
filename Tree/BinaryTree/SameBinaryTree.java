import java.util.*;

public class SameBinaryTree{
    public boolean checkTree(Node root1, Node root2){
        if(root1!=null && root2!=null && root1.val == root2.val){
            boolean left = checkTree(root1.left, root2.left);
            boolean right = checkTree(root1.right, root2.right);
            return (left && right)
        }else if(root1==null && root2==null){
            return true;
        }else{
            return false;
        }
    }
}