public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if( !map.containsKey(i)){
                int left = map.containsKey(i-1) ? map.get(i-1) : 0;
                int right = map.containsKey(i+1) ? map.get(i+1) : 0;
                int len = left + right + 1;
                map.put(i,len);
                res = Math.max(res,len);
                map.put(i-left,len);
                map.put(i+right,len);    
            }
        }
        return res;
    }
}