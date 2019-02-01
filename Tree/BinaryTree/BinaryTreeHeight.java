import java.lang.*;

class BinaryTreeHeight{
    public int getTreeHeight(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right))+1;
    }
}