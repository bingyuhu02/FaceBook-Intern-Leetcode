public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0 ; i < size ; i ++){
                TreeNode node= queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right != null ) queue.offer(node.right);
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
        
    }
}