public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(!map.containsKey(n)) map.put(n,1);
            else map.put(n,map.get(n)+1);
        }
        for( int key : map.keySet()){
            int freq = map.get(key);
            if( bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        for(int i = bucket.length - 1 ; i >= 0 && res.size() < k ;i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}