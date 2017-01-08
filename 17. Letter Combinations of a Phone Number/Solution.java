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