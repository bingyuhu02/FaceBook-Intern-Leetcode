public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] freq = new int[256];
        int count = 0, left = 0, right = 0;
        int max = 0;
        while( right < s.length()){
            if(freq[s.charAt(right)]++ == 0 ) count++;
            while( count > k ){
                char ch = s.charAt(left++);
                freq[ch]--;
                if(freq[ch] == 0){
                    count--;
                }
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}