public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if( nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1); 
        for( int i = 0; i < n ; i++){
            sum += nums[i];
            if( map.containsKey(sum - k) ){
                res = Math.max( res, i - map.get(sum-k) );
            }
            if( !map.containsKey(sum) ) map.put(sum,i);
        }
        return res;
    }
}