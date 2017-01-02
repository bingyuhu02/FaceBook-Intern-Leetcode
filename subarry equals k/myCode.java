
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        System.out.println(sol.subArraySum(new int[] {1,2,-10,10},0));
    
    }
    public boolean subArraySum(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0;
        for(int i=0 ; i < arr.length ; i++){
            sum += arr[i];
            if( arr[i] == target || sum == target || map.get(sum-target) != null ){
                return true;
            }
            map.put(sum,i);
            
        }
        return false;
    }        
}
