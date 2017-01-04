class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        String res = sol.lengthOfLongestSubstringKDistinct("eceba",2);
        
        System.out.println(res);
    }
    public String lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] freq = new int[256];
        int count = 0, left = 0, right = 0;
        int max = 0;
        int start = 0, end = 0;
        while( right < s.length()){
            if(freq[s.charAt(right)]++ == 0 ) count++;
            while( count > k ){
                char ch = s.charAt(left++);
                freq[ch]--;
                if(freq[ch] == 0){
                    count--;
                }
            }
            if( right - left + 1 > max ){
                max = right - left + 1;
                start = left;
                end = right;
            }
            right++;
        }
        return s.substring(start,end+1);
    }
}
