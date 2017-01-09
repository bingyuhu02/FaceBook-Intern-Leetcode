public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        if ( digits.length() == 0 ) return res;
        String[] keys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for(int i=0 ;i < digits.length() ; i++){
            int number = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length() == i){
                String oldStr = res.remove();
                for(char s : keys[number].toCharArray()) res.add(oldStr+s);
            }
        }
        return res;
    }
}


public class Solution {
    private static final String[] keys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if( digits == null || digits.length() == 0 ) return res;
        StringBuilder sb = new StringBuilder();
        dfs(sb,digits,0,res);
        return res;
    }
    private void dfs(StringBuilder sb, String digits, int pos , List<String> res){
        if( sb.length() >= digits.length()){
            res.add(sb.toString());
            return;
        }
        String s = keys[digits.charAt(pos) - '0'];
        int len = sb.length();
        for( int i = 0 ; i < s.length(); i++ ){
            dfs(sb.append(s.charAt(i)), digits, pos + 1 , res );
            sb.setLength(len);
        }
    }
}