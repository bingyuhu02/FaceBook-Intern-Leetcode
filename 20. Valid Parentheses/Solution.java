public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if ((s.length()&1) == 1) return false;
        char [] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for ( char c : str ){
            if ( c == '{' || c == '[' || c == '('){
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else{
                    char left = stack.pop();
                    if ( left == '{' && c == '}' ||
                          left == '(' && c == ')' || 
                          left == '[' && c == ']'){
                              continue;
                          } else return false; 
                }
                
            }
        }
        return stack.isEmpty();
    }
}