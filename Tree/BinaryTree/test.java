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
    public ArrayList<Integer> postorder(){
        ArrayList<Integer> arr = new ArrayList<>();
        postorder(this.root, arr);
        return arr;
    }
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
    public ArrayList<Integer> reverseLevelOrderTraversal(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        Node curr =  root;
        q.add(curr);
        while(q.size()>0){
            curr = q.poll();
            st.push(curr.val);
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
public class test{
    public static void main(String[] args){
        BinarySearchTree bt = new BinarySearchTree();
        BinarySearchTree bt2 = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        bt.add(5); bt.add(1); bt.add(4); bt.add(2); bt.add(6);
        bt2.add(5); bt2.add(1); bt2.add(4); bt2.add(1);
        ArrayList<Integer> res = new ArrayList<>();
        System.out.println(bt.validBST(bt.getRoot(),Integer.MIN_VALUE,Integer.MAX_VALUE));
        res = bt.reverseLevelOrderTraversal(bt.getRoot());
        System.out.println(res);
    }
}