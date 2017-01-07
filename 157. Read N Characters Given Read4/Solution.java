public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean end = false; // end of file flag 
        int res = 0;
        char[] temp = new char[4];
        while( !end && res < n){
            int count = read4(temp);
            end = count < 4 ; // count == 4 -> false;
            count = Math.min(count, n-res);
            for(int i = 0 ; i < count ; i ++){
                buf[res++] = temp[i];
            }
        }
        return res;
    }
}