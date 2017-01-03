import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        boolean test = sol.oneEditDistance(new char[] {'a','e','b','c'}, new char[] {'a','b','c'});
        System.out.print(test);
    }
    public boolean oneEditDistance(char[] s, char[] t){
        if( s.length == 0 && t.length == 0 ) return false;
        if( Arrays.equals(s,t) ) return false; 
        if( Math.abs(s.length - t.length) > 1 ) return false;
        
        for( int i = 0 ; i < Math.min(s.length,t.length) ; i++){
            if( s[i] != t[i] ){
                if(s.length == t.length){
                    for(int j = i +1 ; j < s.length ; j++ ){
                        if(s[j] != t[j]) return false;
                        
                    }
                    return true;
                }
                else if( s.length > t.length ){
                    for( int j = i ; j < t.length ; j++){
                        if( s[j+1] != t[j] ) return false;
                    }
                    return true;
                }
                else{
                    for ( int j = 1 ; j < s.length ; j++){
                        if(s[j] != t[j+1]) return false;
                    }
                    return true;
                }
            }
            
        }
        return Math.abs(s.length - t.length) == 1; 
    }
}
