# 23. Merge k Sorted Lists
# Idea (heap)
* For K Sorted Lists, uses K pointers, too complicated !
* What kind of data structure can be used to find the minimum : minHeap!
* Create a dummy node and put the head as the next of it
* Put the first node of every sort list in the heap, and then heapfiy
* Output the minimum as the head
* if list just extract fromt sill has element, add it to the heap

# Time
* Heapify O(k) , k is the size of heap 
* Push / Poll an element O(logK)
* Total time : Suppose the total number of nodes is n The total time complexity if (n * log k). For a priority queue, insertion takes logK time


# Space
* The size of heap, O(k)


# Time
* O(ave(n) * klogk)

# Space
* O(1) without recursion stack



#Code (Heap)

```
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

```

#Follow up (Merge sort)
* Can we do it without heap? Yes
* MergeSort : for 5 lists, merge List 1 and List 2 and generate List 12, merge 3 and 4 and generate List 45 , merge 12 and 3 and generate List 123, finally generate List 12345
* Every list will be manipulated logN times

# Code (Merge Sort)
```

```