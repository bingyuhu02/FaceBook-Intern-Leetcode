# Cycle sort 

## Idea
* Find the position of each element in the sorted version of input array
* Move the element to that calculated position and start again for the element which you took out to make room for the element whose position in sorted array was found.
* Reach the exact same position from where you started. Once, you encounter a cycle, you start from the next index
* Choose first index, find how many number is smaller than nums[0]
* For example, 4 in total is smaller, than swap n[0] and n[4]
* Use the same way to calculate new n[0]


## Time 
* O(n^2)

## Space 
* In place 

## Code

```

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] test = {20,14,17,21,3,6,2,1,4,20};
        myCode sol = new myCode();
        sol.cycleSort(test);
        for( int i = 0 ; i < test.length ; i++ ){
            System.out.print(test[i] + ", ");
        }
    }
    public void cycleSort(int[] array){
        int pos;
        int cur;
        for(int i = 0 ; i < array.length - 1 ; i++){
            cur = array[i];
            pos = i;
            for( int j = i + 1 ; j < array.length ; j++ ){
                if( array[j] < cur ) pos++;
            }
            if( pos == i ) continue;
            while( cur == array[pos]) pos++;
            if( cur != array[pos]){
                int temp = array[pos];
                array[pos] = cur;
                cur = temp;
            }
            while( pos != i ){
                pos = i;
                for( int k = i + 1 ; k < array.length ; k++){
                    if( array[k] < cur ) pos++;
                }
                while( cur == array[pos] ) pos++;
                if( cur != array[pos]){
                    int temp = array[pos];
                    array[pos] = cur;
                    cur = temp;
                }
            }
        }
    }
}

```