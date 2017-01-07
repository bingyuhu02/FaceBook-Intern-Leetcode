public class Solution {
    public int[] maxSlidingWindow(int[] n, int k) {
        if( n == null || k <= 0 ) return new int[0];
        int len = n.length;
        int[] res = new int[len-k+1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0 ; i < len ; i++){
            // remove  numbers out o range k
            while( !deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // remove smaller
            while( !deque.isEmpty() && n[deque.peekLast()] < n[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if( i >= k - 1 ){
                res[index++] = n[deque.peek()];
            }
            
        }
        return res;
    }
}