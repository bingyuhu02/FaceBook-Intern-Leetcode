# Dot product 

## Question
Give A={a1, a2, a3,…}, B={b1, b2, b3,…} 

dot_product = a1 * b1 + a2 * b2 + a3 * b3 ＋。。。

## Code
```
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] a = {1,2,3};
        int[] b = {2,2,0};
        myCode sol = new myCode();
        int res = sol.dotProduct(a,b);
        System.out.println(res);
    }
    public int dotProduct(int[] a, int[] b){
        int len = a.length;
        int res = 0;
        for( int i = 0 ; i < len ; i++){
            res += a[i] * b[i];
        }
        return res;
    }
}
```

# Follow - up  : sparse vector
## Question
If the array is very sparse

A={a1, ...., a300, ...., a5000}

B={...., b100, ..., b300, ..., b1000, ...}

input A=[[1, a1], [300, a300], [5000, a5000]]
B = [[100, b100], [300, b300], [1000, b1000]]


## Code 

```
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        List<int[]> listA = new ArrayList<>();
        List<int[]> listB = new ArrayList<>();
        listA.add(new int[]{1,1});
        listA.add(new int[]{300,2});
        listA.add(new int[]{500,2});
        listB.add(new int[]{300,2});
        listB.add(new int[]{500,10});
        myCode sol = new myCode();
        int ans = sol.dotProduct(listA,listB);
        System.out.print(ans);

    }
    public int dotProduct(List<int[]> listA, List<int[]> listB){
        int res = 0;
        for( int[] a : listA){
            int indexA = a[0];
            for( int[] b : listB ){
                int indexB =  b[0];
                if( indexA == indexB ) res += a[1] * b[1];
                else if ( indexA > indexB ) continue;
                else break;
            }
        }
        return res;

    }
}

```
# Follow - up  : if input B is too longe

## Idea 
* Find the index of shorter list first
* Binary search index B based on indexA

## Time complexity
* O(nlogm) (n = len(A), m =len(B))


