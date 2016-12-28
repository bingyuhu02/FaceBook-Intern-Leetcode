import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        String a = "11";
        String b = "1";
        myCode sol = new myCode();
        System.out.println(sol.addBinary(a,b));

    }
    private String addBinary(String a, String b){
        if( a == null || a.length() == 0 ) return b;
        if( b == null || b.length() == 0 ) return a;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder  sb = new StringBuilder();
        int val = 0;
        while ( i >=0 || j >=0 ){
            if( i>= 0) val += a.charAt(i--) - '0';
            if( j>= 0) val += b.charAt(j--) - '0';
            sb.append(val%2);
            val = val / 2;
            
        }
        if( val != 0 ) sb.append(val);
        return sb.reverse().toString();
    }

}
