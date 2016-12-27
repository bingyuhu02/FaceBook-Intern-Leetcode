public class Solution{
	static TreeNode prev = null;
	static TreeNode head;
	public void covert(TreeNode root){
		if(root == null ) return;
		convert(root.left);
		if(prev == null){
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convert(root.right)
	}
}