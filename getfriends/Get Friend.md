# Get Friend

## Code (find common friends)
```
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        String a = "12345";
        String b = "26";
        myCode sol = new myCode();
        List<Character> res = sol.findSame(a,b);
        for(Character aws : res){
            System.out.print(aws);
        }
    }

    public List<Character> findSame(String a, String b){
        Set<Integer> hs = new HashSet<>();
        List<Character> res = new ArrayList<>();
        int pos = 0;
        for( int i = 0 ; i < a.length() ; i++ ){
            hs.add(a.charAt(i) - '0');
        }
        for( int i = 0 ; i < b.length() ; i++ ){
            if(hs.contains(b.charAt(i) - '0')){
                res.add(b.charAt(i));
            }
        }
        return res;
    }
}
```

## Code ( find friend's friend)

```
public List<Integer> findCommonFriend(int id){
    List<Integer> res = new ArrayList<>();
    int[] friend = getFriend(id);
    for( int i = 0 ; i < friend.length ; i++){
        int[] nextFriend = getFriend(friend[i]);
        for(int j = 0 ; j < nextFriend.length ; j++){
            if( nextFriend[j] != id){
                res.add(nextFriend[j]);
                //if( !map.containsKey(nextFriend[j])) map.put(nextFriend[j],1);
                //else map.put(nextFriend[j],map.get(nextFriend[j])+1);
            }
        }
    }
    return res;
}

```

## Idea ( Find top k friends )
* Bucket sort 
* Tree map ( use frequency as key )

## Code (bucket sort )


```
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(!map.containsKey(n)) map.put(n,1);
            else map.put(n,map.get(n)+1);
        }
        for( int key : map.keySet()){
            int freq = map.get(key);
            if( bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        for(int i = bucket.length - 1 ; i >= 0 && res.size() < k ;i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
```