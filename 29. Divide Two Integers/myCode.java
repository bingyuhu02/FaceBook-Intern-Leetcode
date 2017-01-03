class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        int res = sol.divide(-7,2);
        System.out.println(res);

    }
    public int divide(int a, int b) {
        if( a == 0) return 0;
        if( b == 1) return a;
        if( b == 0 || (b == -1 && a == Integer.MIN_VALUE)) return Integer.MAX_VALUE;
        int sign = (a > 0 && b > 0) || ( a < 0 && b < 0) ? 1 : -1;
        long first = Math.abs((long)a) , second = Math.abs((long)b);
        if( first < second) return 0;
        int count = 0;
        while( first >= second ){
            first -= second;
            count++;
        }
        return count * sign;
    }
}
