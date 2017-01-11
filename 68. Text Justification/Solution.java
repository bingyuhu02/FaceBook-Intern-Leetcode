public class Solution {
    public List<String> fullJustify(String[] words, int max) {
        List<String> res = new ArrayList<>();
        int cur = 0;
        while ( cur < words.length){
            int count = words[cur].length();
            int next = cur + 1;
            while( next < words.length){
                if ( words[next].length() + count + 1 > max) break;
                count += words[next].length() + 1;
                next++;
            }
            StringBuilder  sb = new StringBuilder();
            int diff = next - cur - 1;
            // left - justified 
            if( next ==  words.length || diff == 0){
                for(int i = cur; i < next ; i++){
                    sb.append(words[i]+" ");
                }
                sb.deleteCharAt(sb.length() - 1 );
                for( int i = sb.length() ; i < max ; i++){
                    sb.append(" ");
                }
            } else {
                 // middle justidie
                int space = ( max - count ) / diff;
                int right = ( max - count ) % diff;
                for( int i = cur ; i < next ; i++){
                    sb.append(words[i]);
                    if( i < next - 1){
                        for( int j = 0 ; j <= (space + (( i - cur ) < right ? 1 : 0)) ; j++){
                            sb.append(" ");
                        } 
                    }
                }
            }
            res.add(sb.toString());
            cur = next;
        }
        return res;
    }
}