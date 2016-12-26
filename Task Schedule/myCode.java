class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] test = {1,1,2,2,1};
        myCode sol = new myCode();
        System.out.println(sol.task(test,2));
    }
    public int task(int[] tasks, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int task : tasks){
            if(map.containsKey(task)){
                int endTime = map.get(task) + k + 1;
                if( endTime > res){
                    res = endTime;
                } else{
                    res++;
                }
            } else res++;
            map.put(task,res);
        }
        return res;
        
    }
}
