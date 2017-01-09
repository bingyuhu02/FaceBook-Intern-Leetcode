class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        String test = "wwwwabbbbcc";
        
        myCode sol = new myCode();
        
        String res = sol.encode(test);
        
        System.out.print(res);
            
    }
    public String encode(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for( int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            while( i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
               count++;
               i++;
            }
            sb.append(count);
            count = 1;
            sb.append(c);
        }
        return sb.toString();
    }
}

