import java.util.*;
import java.lang.*;

public class AVLtree{
    private Node root;
    private class Node{
        int val;
        Node left,right;
        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    private int getHeight(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    private Node rotateRight(Node root){
        Node temp = root;
        root = root.left;
        temp.left = root.right;
        root.right = temp;
        return root;
    }

    private Node rotateLeft(Node root){
        Node temp = root;
        root = root.right;
        temp.right = root.left;
        root.left = temp;
        return root;
    }

    private Node checkBalance(Node root){
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        if((lHeight-rHeight)>1){
            if(root.left!=null){
                int diff = getHeight(root.left.left) - getHeight(root.left.right);
                if(diff<0){
                    root.left = rotateLeft(root.left);
                }
                root = rotateRight(root);
            }
        }else if((lHeight-rHeight)<-1){
            if(root.right!=null){
                int diff = getHeight(root.right.left) - getHeight(root.right.right);
                if(diff>0){
                    root.right = rotateRight(root.right);
                }
                root = rotateLeft(root);
            }
        }
        return root;
    }
    
    private Node add(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        if(data<root.val){
            root.left = add(root.left,data);
        }else if(root.val<data){
            root.right = add(root.right,data);
        }
        root = checkBalance(root);
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
        root = add(this.root,data);
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