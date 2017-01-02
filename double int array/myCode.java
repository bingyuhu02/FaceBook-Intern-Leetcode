class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        int[] test = {5,5,5};
        int[] res = sol.doubleIntArray(test);
        for( int i = 0 ; i < res.length ; i++){
            System.out.print(res[i]);
        }
    }
    public int[] doubleIntArray(int[] arr){
        int[] res = new int[arr.length+1];
        int index = 0;
        int carry =  0;

        for(int i = arr.length - 1 ; i >=0 ; i-- ){
            int total = arr[i] * 2 + carry;
            int cur = total % 10;
            res[index++] = cur;
            carry = total / 10;
        }
        if(carry != 0) res[index++] = carry;

        for(int i = 0 ; i <  res.length / 2; i++ ){
            int temp = res[i];
            res[i] = res[res.length - i -1];
            res[res.length - i -1] = temp;
        }
        return res;
    }
}
