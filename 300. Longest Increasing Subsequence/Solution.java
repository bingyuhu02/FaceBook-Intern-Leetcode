public class Solution {
    public int lengthOfLIS(int[] n) {
        if(n == null || n.length == 0 ) return 0;
        int[] dp = new int[n.length];
        dp[0] = n[0];
        int len = 0;
        for( int i = 1; i < n.length; i++){
            int pos = bs(dp,len,n[i]);
            if(n[i]<dp[pos]) dp[pos] = n[i];
            if(pos>len){
                len = pos;
                dp[len] = n[i];
            }
        }
        return len+1;
    }
    private int bs(int[] arr, int len, int target){
        int l = 0;
        int r = len;
        while( l + 1 < r){
            int m = l + (r - l) /2;
            if(arr[m] == target) return m;
            else{
                if(arr[m] < target) l = m;
                else r = m;
            }
        }
        if(arr[r] < target) return len+1;
        else if (arr[l] >= target) return l;
        else return r;
    }
}