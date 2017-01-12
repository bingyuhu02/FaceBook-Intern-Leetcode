public class BTtoDLL{

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        BTtoDLL sol = new BTtoDLL();

        sol.convert(root);
        sol.generateCycle(head);

        while ( root != null ){
            System.out.print(head.val);
            head = head.right;
        }
    }

    TreeNode prev = null;
    static TreeNode head;
    public void convert(TreeNode root){

        if(root == null ) return;
        convert(root.left);
        if(prev == null){
            head = root;

        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
    }

    public void generateCycle(TreeNode root){
        TreeNode pre = root , head = root;
        while( head.right != null ){
            head = head.right;
        }
        head.right = pre;
        pre.left = head;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}