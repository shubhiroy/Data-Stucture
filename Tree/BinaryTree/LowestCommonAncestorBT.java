import java.util.*;

public class LowestCommonAncestorBT{
    private boolean getNodePath(Node root, int val, ArrayList<Integer> arr){
        if(root==null){
            return false;
        }
        if(root.val == val){
            arr.add(0,root.val);
            return true;
        }
        boolean left = getNodePath(root.left,val,arr);
        boolean right = getNodePath(root.right,val,arr);
        if((left||right)==true){
            arr.add(0,root.val);
            return true;
        }else{
            false;
        }
    }
    public int lcaBT(Node root, int val1, int val2){
        ArrayList<Integer> arrVal1 = new ArrayList<>();
        ArrayList<Integer> arrVal2 = new ArrayList<>();
        if(getNodePath(root,val1,arrVal1)==false || getNodePath(root,val2,arrVal2)==false){
            return -1;
        }
        int i=0;
        while((i<arrVal2.size() && i<arrVal1.size() && arrVal1.get(i)==arrVal2.get(i))){
            i++;
        }
        if(i>=arrVal2.size()){
            return arrVal2.get(i-1);
        }else if(i>=arrVal1.size()){
            return arrVal1.get(i-1);
        }else{
            return arrVal1.get(i-1);
        }
    }
}