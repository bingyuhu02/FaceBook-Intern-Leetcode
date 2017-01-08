public class Solution {
    public void connect(TreeLinkNode root) {
        // Logic: 
        //        node moves to all nodes in tree in level order fashion
        //        needle keeps sewing together next level's children

        // dummy is keeping track of start node of next level
        TreeLinkNode node = root, dummy= new TreeLinkNode(0);
        
        while(node != null){ // this loop is for different levels
        
            // cur is sewing next fields in current level
            // first time in a level, it is same as dummy (with null next)
            // but as soon as we get a non null child from node
            // needle threads that child into its next, 
            //      --------->>  thus making that child as next dummy
            TreeLinkNode cur = dummy;
        
            // this loop moves node in current level
            while(node != null){
                
                if(node.left != null){
                    cur.next = node.left;
                    cur = cur.next;
                }
                if(node.right != null){
                    cur.next = node.right;
                    cur = cur.next;
                }
                
                node = node.next; // move node to next in same level, end up null at rightmost
            }
            // current level ended in node being null
            // take node fom sentinel's next, which is next levels start
            node = dummy.next;
            
            // levelhead.next grabbed into node above, it has been used
            // so make it null so next time we dont grab again, 
            //    if all next lvl is null, it remains null prompting end of run
            dummy.next = null;  
        }
    }