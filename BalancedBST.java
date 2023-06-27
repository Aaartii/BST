
import java.util.*;
public class BalancedBST  {
   
public BSTNode root = null;

    int h(BSTNode N) {
        if (N == null)
            return 0;
 
        int l= h(N.left);
        int r= h(N.right);
        return 1+ Math.max(l, r);
    }
    BSTNode rightsiderotate(BSTNode y) {
         
        BSTNode x = y.left;
        BSTNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(h(y.left), h(y.right)) + 1;
        x.height = Math.max(h(x.left), h(x.right)) + 1;
        return x;
    }
    BSTNode leftsiderotate(BSTNode x) {
        
        BSTNode y = x.right;
        BSTNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(h(x.left), h(x.right)) + 1;
        y.height = Math.max(h(y.left), h(y.right)) + 1;
        return y;
        
    }
    int getBalance(BSTNode Nodee) {
        if (Nodee == null)
            return 0;
 
        return h(Nodee.left) - h(Nodee.right);
    }

    public BSTNode helpinsert(BSTNode root,int key){
        if (root == null)
        return (new BSTNode(key));

    if (key < root.value){
        root.left = helpinsert(root.left,key);}
    else if (key > root.value){
        root.right = helpinsert(root.right, key);}
    else 
        return root;

    
    root.height = 1 + Math.max(h(root.left),h(root.right));
    int balance = getBalance(root);

    if ( balance > 1 && key > root.left.value ) {
        root.left = leftsiderotate(root.left);
        return rightsiderotate(root);
    }
    if (balance < -1 && key > root.right.value  )
        return leftsiderotate(root);
    
    if (balance > 1 && key < root.left.value)
        return rightsiderotate(root);

   
    if ( balance < -1 && key < root.right.value ) {
        root.right = rightsiderotate(root.right);
        return leftsiderotate(root);
    }
    return root;
}

    public void insert(int key){
        root=helpinsert(root,key);
        
    }

    public boolean searchBST(int num) {
        BSTNode temp = root;

        while (temp != null) {
            if (num == temp.value) 
            
            {
                return true;
            } 
            else if (num < temp.value) {
                temp = temp.left;
            } 
            
            else {
                temp = temp.right;
            }
        }
        // TO be completed by students
        return false;
    }
    
    public boolean delete(int key){
        if(searchBST(key)){ 
        root = deletehelp(root, key);
        return true;
        }

	return false;
    }
    BSTNode deletehelp(BSTNode root, int key)
    {
        if (root == null)
            return root;
 
        
        if (key < root.value)
            root.left = deletehelp(root.left, key);
        else if (key > root.value)
            root.right = deletehelp(root.right, key);
        else {
            
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minimum(root.right);
 
            root.right = deletehelp(root.right, root.value);
        }
 
        return root;
    }
 
    int minimum(BSTNode root)
    {
        int temp = root.value;
        while (root.left != null) {
            temp = root.left.value;
            root = root.left;
        }
        return temp;
    }
    public ArrayList<Integer> inorder() {
		ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        
        inOrderHelper(root, al);

        
        return al;
    }
        public ArrayList<Integer> inOrderHelper(BSTNode root, ArrayList<Integer> l){
   
        if(root == null) return null;
        inOrderHelper(root.left, l);
        l.add(root.value);
        inOrderHelper(root.right, l);
        
        return l;

    }
    

}