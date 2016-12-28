public class myCode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        myCode sol = new myCode();
        List<String> res = sol.binaryTreePaths(root);
        for(String s : res){
            System.out.print(s);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<StringBuilder> qs = new LinkedList<>();
        Queue<TreeNode> qt = new LinkedList<>();
        qs.add(new StringBuilder());
        qt.add(root);
        while( !qt.isEmpty()){
            TreeNode node = qt.remove();
            StringBuilder sb = qs.remove();
            if( node.left == null && node.right == null ) res.add(sb.append(node.val).toString());
            if( node.left != null){
                StringBuilder temp = new StringBuilder(sb);
                qt.add(node.left);
                qs.add(temp.append(node.val).append("->"));
            }
            if( node.right != null){
                StringBuilder temp = new StringBuilder(sb);
                qt.add(node.right);
                qs.add(temp.append(node.val).append("->"));
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}