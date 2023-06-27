import java.util.*;
public class BST {

   
    
    public BSTNode root;

    public BST() {
        root = null;
    }
    public static int bstheight(BSTNode root){
        if (root == null){
            return 0;
        }
        int leftheight = bstheight(root.left);
        int rightheight = bstheight(root.right);
        int finalheight = Math.max(leftheight, rightheight) + 1 ;
        return finalheight;
    }
    // static void UpdateHeight(BSTNode t){
    //     if(t==null){
    //         return;
    //     }
    //     else{
    //         UpdateHeight(t.left);
    //         t.height=bstheight(t);
    //         UpdateHeight(t.right);

    //     }
    // }


    public void insert(int num) {
       
        BSTNode newnode = new BSTNode(num);
        if (root == null) {
            root = newnode;
            //UpdateHeight(root);
          
            return;
        
        }
        BSTNode prev = null;
        BSTNode temp = root;
        while (temp != null) {
            if (temp.value > num) {
                prev = temp;
                temp = temp.left;
            }
            else if (temp.value < num) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.value > num)
            prev.left = newnode;
        
        else
            prev.right = newnode;
           // UpdateHeight(root);
            return;
        // TO be completed by students
        
    }

    public boolean delete(int num) {
        
        if(search(num)){

        
        root = deletehelp(root, num);
        //UpdateHeight(root);
        return true;
        }
        return false;
        
    }

    public BSTNode deletehelp(BSTNode root, int num) {
        if (root == null) {
            return root;
        }

        if (num < root.value) 
        {
            root.left = deletehelp(root.left, num);
        } else if (num > root.value) {
            root.right = deletehelp(root.right, num);
        }
         else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
                else{
                    root.value = m(root.left);
                    root.left = deletehelp(root.left, root.value);
                }
            }
            
        return root;
    }

    public int m(BSTNode root) {
        
        int temp = root.value;
        

        while (root.right != null) {
            temp = root.right.value;
            root = root.right;
        }
        return temp;
    }
    public boolean search(int num) {
        
        BSTNode tem = root;

        while (tem != null) {
            if (num == tem.value) 
            
            {
                return true;
            } 
            else if (num < tem.value) {
                tem = tem.left;
            } 
            
            else {
                tem = tem.right;
            }
        }
       
        // TO be completed by students
        return false;
    }

    public ArrayList<Integer> inorder() {
        
		ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        
        inOrderHelper(root, al);

        // for(int i = 0; i< al.size(); i++){
        //     System.out.print(al.get(i) + " ");
        // }
        // System.out.println();
        return al;
    }
        public ArrayList<Integer> inOrderHelper(BSTNode root, ArrayList<Integer> l){
   
        if(root == null) return null;
        inOrderHelper(root.left, l);
        l.add(root.value);
        inOrderHelper(root.right, l);
        
        return l;

    }
        
    public ArrayList<Integer> preorder() {
        // TO be completed by students
      
		ArrayList<Integer> al = new ArrayList<>();
         if(root == null) return al;
        
        preOrderHelper(root, al);

        // for(int i = 0; i< al.size(); i++){
        //     System.out.print(al.get(i) + " ");
        // }
        // System.out.println();
		return al;
    }
    
    public ArrayList<Integer> preOrderHelper(BSTNode root, ArrayList<Integer> l){
   
        if(root == null) return null;
        l.add(root.value);
        preOrderHelper(root.left, l);
        preOrderHelper(root.right, l);
        
        return l;
    }

    public ArrayList<Integer> postorder() {
        
        // TO be completed by students
		ArrayList<Integer> al = new ArrayList<>();
        
        if(root == null) return al;
        
        postOrderHelper(root, al);

        // for(int i = 0; i< al.size(); i++){
        //     System.out.print(al.get(i) + " ");
        // }
        // System.out.println();
        return al;
    }

    public ArrayList<Integer> postOrderHelper(BSTNode root, ArrayList<Integer> l){
   
        if(root == null) return null;
        postOrderHelper(root.left, l);
        postOrderHelper(root.right, l);
        l.add(root.value);
        return l;

    }
   
}
    
 

    
