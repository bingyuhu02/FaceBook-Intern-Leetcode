# Binary Tree to Doubly Linked List

## Idea 
* If left child exists, process the left substree
* Recursively convert the left substree to DLL
* Inoder traversal 
* Update previous node and current node

## Code 

```
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
```

## Code ( Inorder traversal)

```
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

```