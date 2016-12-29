# No Empty Cell

## Code 

```
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {

        myCode sol = new myCode();
        System.out.print(sol.returnEmptyCell(8,new int[]{3,5}));

    }
    public int returnEmptyCell(int slots , int[] emptyCell){
        Set<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < emptyCell.length ; i++){
            hs.add(emptyCell[i]);
        }
        List<Integer> list  = new ArrayList<>();
        for(int i = 1 ; i <= 8 ; i++){
            if(!hs.contains(i)){
                list.add(i);
            }
        }
        int rand = new Random().nextInt(list.size());
        return list.get(rand);
    }
}


```