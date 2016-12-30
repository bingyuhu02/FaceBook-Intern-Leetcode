public class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int val = 0 ;
        
        for( char c : s.toCharArray()){
            if( Character.isDigit(c)){
                val = val*10+ c - '0' ;
            } else if( c == '['){
                numStack.push(val);
                val = 0;
                strStack.push(sb);
                sb = new StringBuilder();
            } else if ( c == ']'){
                StringBuilder temp = sb;
                sb = strStack.pop();
                for(int i = numStack.pop() - 1;i >=0;i--){
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}