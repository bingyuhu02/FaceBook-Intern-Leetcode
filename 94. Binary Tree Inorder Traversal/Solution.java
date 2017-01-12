public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        boolean done = false;
        while ( !done ){
            if ( cur !=null ){
                s.push(cur);
                cur = cur.left;
            } else {
                if ( s.isEmpty()){
                    done = true;                
                } else {
                    cur = s.pop();
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}

// recursion
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    // method 1: recursion

    helper(root, res);
    return res;

    //helper function for method 1
    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
           }
       }
   }
}