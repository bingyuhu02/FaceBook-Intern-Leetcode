/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        // minHeap
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                if(o1.val < o2.val) return -1;
                else if(o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        // add all head nodes of K list into the heap
        for(ListNode node : lists){
            if( node != null ) heap.add(node);
        }
        // find min elementes in minHeap
        while(!heap.isEmpty()){
            head.next = heap.poll();
            head = head.next;
            // if list just extract fromt sill has element, add it to the heap
            if(head.next != null ) heap.add(head.next);
        }
        return dummy.next;
    }
}