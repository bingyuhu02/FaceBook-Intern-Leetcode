public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if( nums == null || nums.length == 0) return 0;
        int pre = 0 , cur = 0 , sum = 0 , min = Integer.MAX_VALUE;
        while( cur < nums.length ){
            sum += nums[cur++];
            while(sum >= s){
                min = Math.min(min,cur-pre);
                sum -= nums[pre++];
            }
        }
        return min == Integer.MAX_VALUE ? 0:min;
    }
}