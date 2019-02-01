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
    private void postorder(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.val);
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
    public ArrayList<Integer> postorder(){
        ArrayList<Integer> arr = new ArrayList<>();
        postorder(this.root, arr);
        return arr;
    }
}
// class SameBinaryCheck extends SameBinaryTree{
//     SameBinaryTree sb = new SameBinaryTree();
//     public boolean checkTreeEquality(){
//         return sb.checkTree(Node root1, Node root2);
//     }
// }
public class BinarySearchTreeRecurr{
    public static void main(String[] args){
        BinarySearchTree bt = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of nodes : ");
        int n = sc.nextInt();
        int i = 0;
        System.out.println("Enter the node value . ");
        while(i<n){
            bt.add(sc.nextInt());
            i++;
        }
        ArrayList<Integer> res;
        System.out.println("InOrder");
        res = bt.inorder();
        System.out.println(res);
        System.out.println("PreOrder");
        res = bt.preorder();
        System.out.println(res);
        System.out.println("PostOrder");
        res = bt.postorder();
        // System.out.println(res);
        // SameBinaryCheck sc = new SameBinaryCheck();
        // System.out.println(sc.checkTreeEquality());
    }
}