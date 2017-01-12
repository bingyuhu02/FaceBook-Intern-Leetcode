public class BSTIterator {
    TreeNode curr;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        curr = root;    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (curr != null || (!stack.isEmpty()));    
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode node = stack.pop();
        curr  = node.right;
        return node.val;
    }
}