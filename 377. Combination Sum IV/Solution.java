public class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        int res = 0;
        if( nums == null || nums.length == 0 || target < 0) return 0;
        if( target == 0 ) return 1; 
        if( map.containsKey(target) ) return map.get(target);
        for( int i : nums ){
            res += combinationSum4( nums , target - i);
        }
        map.put(target,res);
        return res;
    }
}