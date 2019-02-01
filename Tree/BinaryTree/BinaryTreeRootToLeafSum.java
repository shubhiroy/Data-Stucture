public class BinaryTreeRootToLeafSum{
    public boolean rootToLeafSum(Node root, int sum, ArrayList<Integer> arr){
        if(root.left==null && root.right==null){
            if(sum==root.val){
                arr.add(root.val);
                return true;
            }else{
                return false;
            }
        }
        sum = sum - root.val;
        if(root.left!=null){
            boolean left = rootToLeafSum(root.left, sum, arr);
            if(left==true){
                arr.add(root.val);
                return left;
            }
        }
        if(root.right!=null){
            boolean right = rootToLeafSum(root.right, sum, arr);
            if(right==true){
                arr.add(root.val);
                return right;
            }
        }
        return false;
    }
}