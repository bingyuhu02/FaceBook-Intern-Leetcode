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
	public void generateCycle(ListNode root){
		ListNode pre = root , head = root;
		while( head.right != null ){
			head = head.right;
		}
		head.right = pre;
		pre.left = head;
	}
}

class ListNode {
     int val;
     ListNode left;
     ListNode right;
     ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}