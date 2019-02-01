public class LcaBst{
    public int lowestCommonAnscestor(Node root, int val1, int val2){
        if(root==null){
            return -1;
        }
        if((val1==root.val || val2==root.val) || (val1>root.val && val2<root.val) || (val1<root.val && val2>root.val)){
            return root.val;
        }else if(val1>root.val && val2>root.val){
            return lowestCommonAnscestor(root.right,val1,val2);
        }else if(val1<root.val && val2<root.val){
            return lowestCommonAnscestor(root.left,val1,val2);
        }
        return -1;
    }
}