#380. Insert Delete GetRandom O(1)

## Idea

* Time complexity requirments O(1)
* Use ArrayList to store all variables
* Use HashMap to store values and their locations
* Every insert : location + 1
* Every remove : Put the last value in the removed locatio and remove the last one 


## Code
```
public class RandomizedSet {
    // ArrayList to store values : for getRandom
    // HashMap to track each value and its location
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> map;
    Random r = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,nums.size());
        nums.add(val);
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int loc = map.get(val);
        if(loc < nums.size()-1){
            int last = nums.get(nums.size()-1);
            nums.set(loc,last);
            map.put(last,loc);
        }
        map.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(r.nextInt(nums.size()));
    }
}
```