import  java.util.*;
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

     public BinarySearchTree() {
        size = 0;
        root=null;
    }
    public BinarySearchTree(E val) {
         root = new Node<>(val);
         size=1;
    }
    
// returns true if BST has val else false.
    public boolean contains (E val) {
        Node<E>current=root;
        while (root!=null){
            if (current.getInfo().compareTo(val)!=0){
                if(current.getInfo().compareTo(val)<0){
                    current=current.getRight();
                }
                else {
                    current=current.getLeft();
                }
            }
            if (current.getInfo().compareTo(val)==0){
                return true;
            }
        }
        return false;
    }
// inserts val at the right place satisfying search tree properties, should handle if the tree is empty
// if value is already there then don’t insert it again
    public void insert(E val) {
            if (root==null){
                root = new Node<>(val);
            }
            E hold= root.getInfo();
            if(val.compareTo(hold)<0){
                addLeft(root,val);
            }
            if(val.compareTo(hold)>0){
                addRight(root,val);
            }
    }



// returns the minimum value stored in the tree
public E findMin(Node<E>root) {
         Node <E> maxLeft=root;
         if(!isEmpty()){
            while (maxLeft.getLeft() != null){
                maxLeft=maxLeft.getLeft();
            }
            return maxLeft.getInfo();
         }
         return null;
     }

// returns the maximum value stored in the tree
public E findMax() {
        Node <E> maxRight=root;
        if(!isEmpty()){
            while (maxRight.getRight() != null){
                maxRight=maxRight.getRight();
            }
            return maxRight.getInfo();
        }
        return null;
    }
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);
    }
    
             
}