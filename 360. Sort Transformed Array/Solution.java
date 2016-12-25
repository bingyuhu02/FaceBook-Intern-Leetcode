public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int i = a >=0 ? nums.length - 1 : 0;
        while( start <= end ){
            int startNum = calculate(nums[start],a,b,c);
            int endNum = calculate(nums[end],a,b,c);
            if( a >= 0 ){
                if(startNum >= endNum){
                    res[i--] = startNum;
                    start++;
                } else{
                    res[i--] = endNum;
                    end--;
                }
            } else{
                if(startNum <= endNum) {
                    res[i++] = startNum;
                    start++;
                }
                else{
                    res[i++] = endNum;
                    end--;
                }
            }
        }
        return res;
    }
    private int calculate(int x, int a , int b , int c){
        return a * x * x + b * x + c;
    }
}