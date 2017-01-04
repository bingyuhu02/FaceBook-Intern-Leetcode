// binary search
// O(logn)
public class Solution {
    public boolean isPerfectSquare(int num) {
        if( num < 1 ) return false;
        long l = 1 , r = num;
        while( l <= r ){
            long mid = l + ( r - l) /2 ;
            long res = mid * mid;
            if( res == num ) return true;
            else if( res > num ){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false; 
    }
}