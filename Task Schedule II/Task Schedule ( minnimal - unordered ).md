# Task Schedule ( minnimal / unordered )

## Idea
* Use a map to conunt the frequency of the task that apperas then get the maximum count
* The result is decided by the maximum count and the number of tasks with maximum count
* The min resul is the length of the tasks
* Consider k+1 as a time slot

## Code 

```
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] test = {1,1,2,2,1,2};
        myCode sol = new myCode();
        System.out.println(sol.task(test,2));
    }
    public int task(int[] tasks, int k){
        if(tasks == null || tasks.length == 0) return 0;
        int maxFreq = 0;
        int maxCount = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int task : tasks){
            if(!map.containsKey(task)){
                map.put(task,1);
            } else{
                map.put(task,map.get(task)+1);
            }
            if( maxFreq < map.get(task)){
                maxFreq = map.get(task);
                maxCount = 1;
            } else if ( maxFreq == map.get(task)){
                maxCount++;
            }
            
        }
        return Math.max(tasks.length,(k+1)*(maxFreq-1) + maxCount);
        
    }
}

```