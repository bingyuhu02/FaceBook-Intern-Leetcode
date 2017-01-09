/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        String test = "abbcbad";
        myCode sol = new myCode();
        int res = sol.countPaliWithoutDuplicate(test);
        System.out.println(res);
        
        int res2 = sol.countPaliWithDuplicate(test);
        System.out.println("With duplicate " + res2);
            
    }
    Set<String> res = new HashSet<>();
    // with out duplicate
    public int countPaliWithoutDuplicate(String s){    
        for( int i = 0 ; i < s.length() ; i++){
            StringBuilder sb = new StringBuilder();
            res.add(s.charAt(i) + "");
            sb.setLength(0);
            sb.append(s.charAt(i));
            int left = i - 1;
            int right = i + 1;
            
            if( left >= 0 && right < s.length() ){
                helper(left,right,s,sb);
            }
            sb.setLength(0);
            if( i + 1 < s.length() ){
                helper(i,i+1,s,sb);
            }
        }
        for( String str : res ){
            System.out.println(str);
        }
        return res.size();
    }
    public void helper( int left, int right, String s, StringBuilder sb){
        while( left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                sb.insert(0, s.charAt(left));
                res.add(sb.append(s.charAt(right)).toString());
                left--;
                right++;    
            } else break;
        }
    }
    // with duplicate
    
    public int countPaliWithDuplicate(String s){
        int count = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i<s.length();i++ ){
            int count1 = length(s,i,i);
            int count2 = length(s,i,i+1);
            count = count + count1 + count2;
        }
        return count;
        
        
    }
    private int length(String s, int start, int end){
        int time = 0;
        while( start >=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            time++;
            start--;
            end++;
        }
        return time;
    }
}
