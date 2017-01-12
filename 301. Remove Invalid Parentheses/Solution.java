// time : worst case
//        one level - check if valid o(n)
//        second level ( n - 1 ) new string , each has (n-1) character
// length of n 
// every character has 2 states (keep/remove) 2^n
// check valid is o(n)
// all together o(n*2^n)
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s==null) return res;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while(!queue.isEmpty()){
            s = queue.poll();
            if(isValid(s)){
                res.add(s);
                found = true;
            }
            // skip next function if found
            if(found) continue;
            
            // generate all possible states
            for(int i=0 ; i < s.length() ; i++){
                // try to remove left or right
                if(s.charAt(i) != '(' && s.charAt(i) != ')' ) continue;
                // 0 ~ i - 1  +  i + 1 ~ end
                String t = s.substring(0,i) + s.substring(i+1);
                if(!visited.contains(t)){
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '(') count++;
            if(c == ')' && count-- ==0 ) return false;
        }
        return count == 0;
    }
}




public class Solution {
    public static void main(String[] args) {
        String test = "()())()";
        Solution sol = new Solution();
        String res = sol.removeInvalidParentheses(test);
        System.out.print(res);


    }
    public String removeInvalidParentheses(String s) {
        String res = "";
        if(s==null ) return res;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;
        while( !queue.isEmpty() ){
            s = queue.poll();
            if(isValid(s)){
                res = s;
                found = true;
            }
            if(found) continue;
            for( int i = 0 ; i < s.length(); i++ ){
                if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String t = s.substring(0,i) + s.substring(i+1);
                if(!visited.contains(t)){
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s){
        int count = 0;
        for( int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == '(') count++;
            if( c == ')' && count-- == 0 ) return false;
        }
        return count == 0;
    }
}