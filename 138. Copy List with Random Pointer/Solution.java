public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return head;
        RandomListNode cur = head; 
        // first round : make copy of each node
        // link them tegether side-by-side in a single list 
        while( cur != null){
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        // second round : assign random pointers for the copy nodes 
        cur = head;
        while( cur != null ){
            if( cur.random != null ) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // restore the original list, and extrac the copy list
        cur = head;
        RandomListNode copyHead = head.next;
        RandomListNode copy = copyHead;
        while(copy.next !=null ){
            cur.next = cur.next.next;
            cur = cur.next;
            
            copy.next = copy.next.next;
            copy = copy.next;
        }
        //cur.next = null;
        cur.next = cur.next.next;
        
        return copyHead;
    }
}


class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }



 public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if( head == null ) return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        // loop 1 : copy all node
        RandomListNode cur = head;
        while( cur != null ){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        // loop 2 : assign next and random pointers
        cur = head;
        while( cur != null ){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}