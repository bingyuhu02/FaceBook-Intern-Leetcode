// use stack to save node.
// Preorder traversal 
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            if(!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
        }
    }
}

 public void flatten(TreeNode root) {
     if(root == null)
    return;
    
     flatten(root.left);
     flatten(root.right);
 
     // save current right for concatination
     TreeNode right = root.right;
 
     if(root.left != null) {
     
         // step 1: concatinate root with left flatten subtree
        root.right = root.left;
        root.left = null; // set left to null
    
        // step 2: move to the end of new added flatten subtree
        while(root.right != null)
            root = root.right;
        
        // step 3: contatinate left flatten subtree with flatten right subtree  
        root.right = right;
     }
 }