public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        print(root,sb,res);
        return res;
    }
    private void print(TreeNode node, StringBuilder sb, List<String> res){
        if( node == null ) return;
        int len = sb.length();
        sb.append(node.val);
        if( node.left == null && node.right == null ){
            res.add(sb.toString());
        } else{
            sb.append("->");
            print(node.left, sb, res);
            print(node.right, sb, res);
        }
        sb.setLength(len);
    }
}