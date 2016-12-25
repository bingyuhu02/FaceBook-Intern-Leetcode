class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] tes = {-4,-2,2,4};
        myCode sol = new myCode();
        int[] res = sol.sortTransArray(tes,1,3,5);
        for( int i = 0 ; i < res.length ; i++ ){
            System.out.println(res[i]);
        }
    }
    public int[] sortTransArray(int[] nums, int a , int b, int c ){
        for( int i = 0 ; i < nums.length; i++ ){
            nums[i] = calculate(nums[i],a,b,c);
        }    
        Arrays.sort(nums);
        return nums;
    }
    private int calculate(int x, int a , int b , int c){
        return a * x * x + b * x + c;
    }
}
