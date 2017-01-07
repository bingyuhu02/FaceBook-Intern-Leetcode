class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        int res = sol.findMax(new int[]{1,2,3,3,3});
        System.out.print(res);
    }
    public int findMax(int[] arr){
        if( arr == null || arr.length == 0 ) return -1;
        int max = arr[0];
        int index = 1;
        for ( int i = 1 ; i < arr.length ; i++){
            if( arr[i] == max ){
                int temp = arr[index];
                arr[index] = i;
                arr[i] = temp;
                index++;
            }
            else if( arr[i] > max ){
                max = arr[i];
                index = 0;
                int temp = arr[index];
                arr[index] = i;
                arr[i] = temp;
                index++;
            }
        }
        int random = (int)(Math.random()*index);
        return arr[random];
    }
}


class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        int res = sol.findMax(new int[]{1,2,3,3,3});
        System.out.print(res);
    }
    public int findMax(int[] arr){
        int len = arr.length;
        int res = -1;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<len; i++){
            if( arr[i]==max ){
                count++;
                Random rand = new Random();
                int judge = rand.nextInt(count);
                if( judge == 0){
                    res = i;
                }
            }else if( max == Integer.MIN_VALUE || arr[i] > max){
                max = arr[i];
                res = i;
                count = 1;
            }
        }
        return res;
    }
}

