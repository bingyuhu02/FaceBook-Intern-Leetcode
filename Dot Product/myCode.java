class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] a = {1,2,3};
        int[] b = {2,2,0};
        myCode sol = new myCode();
        int res = sol.dotProduct(a,b);
        System.out.println(res);
    }
    public int dotProduct(int[] a, int[] b){
        int len = a.length;
        int res = 0;
        for( int i = 0 ; i < len ; i++){
            res += a[i] * b[i];
        }
        return res;
    }
}
