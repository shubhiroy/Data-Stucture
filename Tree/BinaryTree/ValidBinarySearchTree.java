public class ValidBinarySearchTree{
    public boolean validBST(Node root, int min, int max){
        if(root==null){
            return true;
        }
        if(root.val>min && max>root.val){
            boolean left = validBST(root.left,min,root.val);
            boolean right = validBST(root.right,root.val,max);
            return (left && right);
        }else{
            return false;
        }
    }
}