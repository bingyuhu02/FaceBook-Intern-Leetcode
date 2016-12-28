public class Solution {
    public String countAndSay(int n) {
        return count("1",n);        
    }
    private String count(String s, int n){
        if(n==1) return s;
        int count = 0;
        String str = "";
        for(int i = 0 ; i < s.length() ; i++ ){
            if( i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                count++;
            }
            else if ( i+1 < s.length() && s.charAt(i) != s.charAt(i+1)){
                count++;
                str+=count+""+s.charAt(i);
                count=0;
            } else {
                count++;
                str += count +"" + s.charAt(i);
            }
        }
        return count(str,n-1);
    }
}


public class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        StringBuilder pre = new StringBuilder();
        for( int i = 1 ; i <  n ; i++ ){
            pre = sb;
            sb = new StringBuilder();
            int count = 1;
            char val = pre.charAt(0);
            
            for( int  j = 1 ; j < pre.length(); j++){
                if( pre.charAt(j) != val){
                    sb.append(count).append(val);
                    count  = 1;
                    val = pre.charAt(j);
                } else count++;
            }
            sb.append(count).append(val);
        }
        return sb.toString();
    }
}