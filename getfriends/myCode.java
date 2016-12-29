import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        String a = "12345";
        String b = "26";
        myCode sol = new myCode();
        List<Character> res = sol.findSame(a,b);
        for(Character aws : res){
            System.out.print(aws);
        }
    }

    public List<Character> findSame(String a, String b){
        Set<Integer> hs = new HashSet<>();
        List<Character> res = new ArrayList<>();
        int pos = 0;
        for( int i = 0 ; i < a.length() ; i++ ){
            hs.add(a.charAt(i) - '0');
        }
        for( int i = 0 ; i < b.length() ; i++ ){
            if(hs.contains(b.charAt(i) - '0')){
                res.add(b.charAt(i));
            }
        }
        return res;
    }
}
