import java.util.*;

public class BinaryTreeSize{
    public int getTreeSize(Node root){
        if(root==null){
            return 0;
        }
        return getTreeSize(root.left) + getTreeSize(root.right) + 1;
    }
}