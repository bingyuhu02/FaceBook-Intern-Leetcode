public class Solution {
    public int maxDepth(TreeNode root) {
        if( root == null ) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while( !queue.isEmpty() ){
            int size = queue.size();
            while(size > 0 ){
                TreeNode node = queue.poll();
                if( node.left != null ) queue.offer(node.left);
                if( node.right != null ) queue.offer(node.right);
                size--;
            }
            count++;
        }
        return count;
    }
}