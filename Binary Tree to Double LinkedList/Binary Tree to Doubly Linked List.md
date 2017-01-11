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
## Lintcode (ListNode and treenode use diffrent class)
```
public class Solution {
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        if (root == null) {
            return null;
        }
        //Init stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;    
        stack.push(node);
        //Create DoublyListNode header
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode dNode = dummy;
        
            
        while(!stack.isEmpty()) {
            while (node != null && node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            //add node
            node = stack.pop();
            DoublyListNode curr = new DoublyListNode(node.val);
            dNode.next = curr;
            curr.prev = dNode;
            dNode = dNode.next;
            
            //check right node and add to stack
            node = node.right;
            if (node != null) {
                stack.push(node);
            }  
        }
        
        return dummy.next;
        
    }
}


 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }

 
  * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }

```


