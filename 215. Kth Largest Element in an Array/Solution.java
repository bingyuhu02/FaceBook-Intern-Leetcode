public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for( int i : nums){
            heap.offer(i);
            if( heap.size() > k ){
                heap.poll();
            }
        }
        return heap.peek();
    }
}


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int pos = quickSelect(nums, 0 , n - 1 , n- k + 1);
        return nums[pos];
    }
    public int quickSelect(int[] a, int l , int r , int k){
        int i = l , j = r , pivot = a[r];
        while( i < j ){
            if( a[i++] > pivot ){
                swap(a,--i,--j);
            }
        }
        swap(a,i,r);
            
        int pos = i - l + 1;
        if( pos == k) return i;
        else if( pos > k ) return quickSelect(a,l,i-1,k);
        else return quickSelect(a,i+1,r,k-pos);
    }
    public void swap(int[] n, int i , int j){
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}