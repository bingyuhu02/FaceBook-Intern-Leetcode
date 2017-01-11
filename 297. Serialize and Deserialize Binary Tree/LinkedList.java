/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

class myCode {
    private String mark = ",";
    private String nn = "N";

    public static void main (String[] args) throws java.lang.Exception {
        TreeNode root = new TreeNode('1');
        root.left = new TreeNode('2');
        root.left.left = new TreeNode('3');
        root.left.right = new TreeNode('4');
        root.right = new TreeNode('5');
        myCode test = new myCode();

        TreeNode res = test.serialize(root);
        while( res != null){
            System.out.print(res.val);
            res = res.right;
        }

    }


    // Encodes a tree to a single string.
    public TreeNode serialize(TreeNode root) {
        TreeNode dummy = new TreeNode('0');
        TreeNode head = dummy;
  
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while ( !stack.isEmpty() ) {
            TreeNode cur = stack.pop();
            head.right = cur;
            head = head.right;
            
            if ( cur.right != null ) stack.push(cur.right);
            else {
                head.right = new TreeNode('N');
                head = head.right;
            }
            if ( cur.left != null ) stack.push(cur.left);
            else {
                head.right = new TreeNode('N');
                head = head.right; 
            }
            
        }
        
        return dummy.right;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(TreeNode head) {
        Deque<Character> deque  = new LinkedList<>();
        while( head != null){
            deque.offerLast(head.val);
            head = head.right;
        }        
        return buildTree(deque);
    }
    private TreeNode buildTree(Deque<Character> deque){
        Character root = deque.remove();
        if(root.equals(nn)) return null;
        else{ 
            TreeNode node = new TreeNode(root);
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }
}

class TreeNode {
      char val;
      TreeNode left;
      TreeNode right;
      TreeNode(char x) { val = x; }
}