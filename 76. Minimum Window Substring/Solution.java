public class Solution {
    public String minWindow(String s, String t) {
        if( s== null ||  t.length() > s.length() ) return "";
        int[] freq = new int[128];
        int start = 0, end = 0;
        int minStart = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        for( char c : t.toCharArray()){
            freq [c]++;
        }
        while(end < s.length()){
            if( freq[s.charAt(end)] > 0) count--;
            freq[s.charAt(end)]--;
            end++;
            while(count == 0 ){
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                freq[s.charAt(start)]++;
                if(freq[s.charAt(start)] > 0) count++;
                start++;
            }
        }
        return (minLen==Integer.MAX_VALUE) ? "" : s.substring(minStart,minStart+minLen);
    }
}