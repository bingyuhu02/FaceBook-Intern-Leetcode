public class Solution extends Reader4 {
    // store the data received in previous calls
    private int bufferPointer = 0;
    private int bufferCount = 0; 
    private char[] temp = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        while( count < n ){
            // start new read , put data into temp buff 
            if( bufferPointer == 0 ) bufferCount = read4(temp);
            if( bufferCount == 0 ) break;
            while( count < n && bufferPointer < bufferCount ) {
                buf[count++] = temp[bufferPointer++];
            }
            // reset bufferPointer
            if(bufferPointer==bufferCount) bufferPointer = 0;
        }
        return count;
    }
}