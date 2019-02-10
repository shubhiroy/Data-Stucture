import java.util.*;
import java.lang.*;

class BinarySearchTree{
    private Node root;
    private class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
    private Node add(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        int comp = (data>root.val)? 1 : (data<root.val)? -1 : 0;
        if(comp==-1){
            root.left = add(root.left,data);
        }else if(comp==1){
            root.right = add(root.right,data);
        }
        return root;
    }
    private void inorder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    private void preorder(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        arr.add(root.val);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }
    public int getTreeSize(Node root){
        if(root==null){
            return 0;
        }
        return getTreeSize(root.left) + getTreeSize(root.right) + 1;
    }
    private void postorder(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.val);
    }
    public boolean checkTree(Node root1, Node root2){
        if(root1!=null && root2!=null && root1.val == root2.val){
            boolean left = checkTree(root1.left, root2.left);
            boolean right = checkTree(root1.right, root2.right);
            return (left && right);
        }else if(root1==null && root2==null){
            return true;
        }else{
            return false;
        }
    }
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
    public void add(int data){
        this.root = add(this.root,data);
    }
    public ArrayList<Integer> inorder(){
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(this.root,arr);
        return arr;
    }
    public ArrayList<Integer> preorder(){
        ArrayList<Integer> arr = new ArrayList<>();
        preorder(this.root, arr);
        return arr;
    }
    public Node getRoot(){
        return this.root;
    }
    public int getTreeHeight(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right))+1;
    }
    private boolean checkVal(Node root, int val){
        if(root==null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        return (checkVal(root.left,val) || checkVal(root.right,val));
    }
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
            return false;
        }
    }
    public int lcaBT(Node root, int val1, int val2){
        ArrayList<Integer> arrVal1 = new ArrayList<>();
        ArrayList<Integer> arrVal2 = new ArrayList<>();
        // getNodePath(root,val1,arrVal1);
        // getNodePath(root,val2,arrVal2);
        if(getNodePath(root,val1,arrVal1)==false || getNodePath(root,val2,arrVal2)==false){
            return -1;
        }
        
        // if(arrVal1.size()==0 || arrVal2.size()==0){
        //     return -1;
        // }
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
class test{
    public static void main(String[] args){
        BinarySearchTree bt = new BinarySearchTree();
        BinarySearchTree bt2 = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        bt.add(5); bt.add(1); bt.add(4); bt.add(2); bt.add(6);
        bt2.add(5); bt2.add(1); bt2.add(4); bt2.add(1);
        ArrayList<Integer> res = new ArrayList<>();
        int r = bt.lcaBT(bt.getRoot(),5,5);
        System.out.println(r);
    }
}