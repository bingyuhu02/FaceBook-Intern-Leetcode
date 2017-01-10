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