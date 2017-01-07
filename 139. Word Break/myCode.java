class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        Set<String> wordDict = new HashSet<>();
        wordDict.add("Face");
        wordDict.add("Book");
        
        myCode sol = new myCode();
        boolean test =  sol.wordBreak("FaceBook",wordDict);
        
        System.out.println(test);
        
    }
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for(int i=1 ; i < len + 1 ; i++){
            for( int j = 0 ; j < i ; j++ ){
                if( f[j] && wordDict.contains(s.substring(j,i))) f[i] = true;
            }
        }
        return f[len];
    }
}
