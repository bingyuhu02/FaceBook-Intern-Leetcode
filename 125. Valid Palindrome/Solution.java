public class Solution {
    public boolean isPalindrome(String s) {
        if( s.isEmpty() ) return true;
        int start = 0, end = s.length() -1;
        char head, tail;
        while(start<=end){
            head = s.charAt(start);
            tail = s.charAt(end);
            if(!Character.isLetterOrDigit(head)){
                start++;
            }
            else if(!Character.isLetterOrDigit(tail)){
                end--;
            } else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
        			return false;
        		}
        		start++;
        		end--;
            }
        }
        return true;
    }
}