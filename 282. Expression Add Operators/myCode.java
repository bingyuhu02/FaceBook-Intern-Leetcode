import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        List<String> res = sol.addOperators("123456789",100);
        for( String s : res){
            System.out.println(s);
        }        
    }
    public List<String> addOperators(String n, int target){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res,sb,n,0,target,0);
        return res;
        
    }
    public void helper(List<String> res,StringBuilder sb, String n,int pos,int target,long sum){
        if( pos ==  n.length()){
            if( target == sum){
                res.add(sb.toString());
            }
            return;
        }
        for(int i=pos;i<n.length();i++){
            // 0 can only appear as itselft, not as the start of another number 
            if(n.charAt(pos) == '0' && i != pos) break;
            long cur = Long.parseLong (n.substring(pos,i+1));
            int len = sb.length();
            if( pos == 0 ){
                helper(res,sb.append(cur),n,i+1,target,cur);
                sb.setLength(len);
            } else {
                helper(res,sb.append("+").append(cur),n,i+1,target,sum+cur);
                sb.setLength(len);
                helper(res,sb.append("-").append(cur),n,i+1,target,sum-cur);
                sb.setLength(len);
            }
        }
    }
}

