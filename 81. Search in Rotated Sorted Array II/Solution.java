public class Solution {
    public boolean search(int[] n, int target) {
        int i = 0;
        int j = n.length - 1;
        while( i <= j ){
            int m = i + ( j - i ) / 2;
            if( n[m] == target ) return true;
            if( n[i] < n[m] ){
                if( target < n[m] && target >= n[i]){
                    j = m - 1;
                } else{
                    i = m + 1;
                }
            }
            else if( n[i] > n[m] ){
                if( target > n[m] && target <= n[j]){
                    i = m + 1;
                } else {
                    j = m -1;
                }
            }
            else i++;
        }
        return false;
        
    }
}