# Longest arithmetic subsequence 

## Idea 
* Maintatin a 2d array 
* len[i][j] means the length of the arithmetic that ends with input[i] and input[j]
* HashMap to record the index of every number
* We traverse the input from index 1 to the end.
* Everytime we meet a number, fix this as the end of sequence
* Then traverse back and try to make every number as second last number
* When we fix one as second last one number, we calculate the gap as input[last] - input[secondLast]
* Look into hashmap to find is there a number in the input equals to input[secondLast]. 
* And check its index whether it is smaller than secondLast.
* If it is. Then this is the third last number. And we should already have length[thridLast][secondLast]
* Then length[secondLast][last] = length[thridLast][secondLast] + 1
* If it is not. We make length[secondLast][last] = 2 -- those two number are the only numbers in the arithmetic 

## Time & Space 
* O(n^2) & O(n^2)

## Code 

```

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] test = new int[] {5,4,2,6,6,-1,-2,6,-4,6,-4} ;
        myCode sol = new myCode();
        int res = sol.findLongest(test);
        System.out.println(res);
    }
    public int findLongest(int[] arr){
        if( arr.length == 2 ) return 2;
        if( arr.length == 1 ) return 1; 
        int maxLen = 2;
        int[][] len = new int[arr.length][arr.length];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < arr.length ; i++ ){
            if( !map.containsKey(arr[i])){
                map.put(arr[i],new ArrayList<Integer>());
            }
            map.get(arr[i]).add(i);
        }
        for( int i = 1 ; i < arr.length ; i++){
            for( int j = i - 1 ; j >=0 ; j--){
                int dif = arr[i] - arr[j];
                int next = arr[j] - dif;
                if(map.containsKey(next)){
                    int nextIndex = -1;
                    for( int k = map.get(next).size() - 1; k >= 0 ; k--){
                        if( map.get(next).get(k) < j){
                            nextIndex = map.get(next).get(k);
                            break;    
                        }
                    }
                    if( nextIndex != -1){
                        len[j][i] = len[nextIndex][j] + 1;
                        maxLen = Math.max(maxLen,len[j][i]);
                    }    
                }
                if( len[j][i] == 0 ){
                    len[j][i] = 2;
                }    
            }
           
        }
        return maxLen;
    }
}


```