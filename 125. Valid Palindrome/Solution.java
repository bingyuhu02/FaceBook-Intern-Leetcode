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



class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        char[] test = {'a','!','a'};
        myCode sol = new myCode();
        boolean res = sol.isValid(test);
        System.out.print(res);
    }
    public boolean isValid(char[] c){
        if( c.length == 0 ) return true;
        int start = 0;
        int end = c.length - 1;
        char head, tail;
        while( start <= end ){
            head = c[start];
            tail = c[end];
            if( !Character.isLetterOrDigit(head) ) start++;
            else if ( !Character.isLetterOrDigit(tail)) end--;
            else{
                if(Character.toLowerCase(head) != Character.toLowerCase(tail)) return false;
                start++;
                end--;
            }
            
        }
        return true;
    }
}
