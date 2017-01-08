public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        for( int i : nums1){
            set.add(i);
        }
        for( int i : nums2){
            if( set.contains(i)){
                inter.add(i);
            }
        }
        int[] res = new int[inter.size()];
        int index = 0;
        for( int i : inter){
            res[index++] = i ;
        }
        return res;
    }
}