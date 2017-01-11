/*
The order of "Postorder" is: left child -> right child -> parent node.
Find the relation between the previously visited node and the current node
Use a stack to track nodes
*/

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
	    LinkedList<Integer> res = new LinkedList<>();
	    Stack<TreeNode> stack = new Stack<>();
	    if (root == null) return res;
	    stack.push(root);
	    while (!stack.isEmpty()) {
		    TreeNode cur = stack.pop();
		    res.addFirst(cur.val);
		    if (cur.left != null) {
			    stack.push(cur.left);
		    }
		    if (cur.right != null) {
			    stack.push(cur.right);
		    } 
	    }
	    return res;
    }
}