import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        TreeNode root1 = new TreeNode(1);    
        root1.left = new TreeNode(1);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
        
        
        TreeNode root2 = new TreeNode(1);    
        root2.left = new TreeNode(1);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(1);
        
        myCode sol = new myCode();
        
        int res = sol.findFirst(root1,root2);
        
        System.out.print(res);
            
    }
    int res = Integer.MIN_VALUE;
    public int findFirst(TreeNode root1, TreeNode root2){
        
        
        if( root1 != null || root2 != null ){
            if( root1.val != root2.val ) res = root1.val;
            
            findFirst(root1.left, root2.left);
            findFirst(root1.right, root2.right);
            
        }
        return res;
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
    
}