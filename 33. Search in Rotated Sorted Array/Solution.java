public class Solution {
    public int search(int[] n, int target) {
        int i = 0;
        int j = n.length - 1;
        while( i <= j ){
            int m = i + ( j - i ) / 2;
            if( n[m] == target ) return m;
            if( n[i] <= n[m] ){
                if( target < n[m] && target >= n[i]){
                    j = m - 1;
                } else{
                    i = m + 1;
                }
            }
            if( n[m] < n[j] ){
                if( target > n[m] && target <= n[j]){
                    i = m + 1;
                } else {
                    j = m -1;
                }
            }
        }
        return -1;
    }
}