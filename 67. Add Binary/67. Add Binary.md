# 67. Add Binary
## Idea 
* Count from end to start, then reverse
* Use carrier


## Code 
```
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        String a = "11";
        String b = "1";
        myCode sol = new myCode();
        System.out.println(sol.addBinary(a,b));

    }
    public String addBinary(String a, String b) {
        if( a == null || a.length() == 0) return b;
        if( b == null || b.length() == 0) return a;
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while( i >= 0 || j >= 0){
            int total = 0;
            int val;
            total += carry;
            if( i >= 0 ) total += a.charAt(i) - '0';
            if( j >= 0 ) total += b.charAt(j) - '0';
            val = total % 2;
            sb.append(val);
            carry = total / 2;
            i--;
            j--;
        }
        if (carry != 0 ) sb.append(carry);
        return sb.reverse().toString();
    }

}

```