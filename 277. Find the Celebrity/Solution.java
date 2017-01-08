public class Solution extends Relation {
    public int findCelebrity(int n) {
        if ( n <= 0 ) return -1;
        if ( n == 1 ) return 0;
        // step 1 : find candidate
        int candidate = 0;
        for ( int i = 1 ; i < n ; i++ ){
            if(knows(candidate,i)) candidate = i;
        }
        // step 2 : check the candidate 
        // check 1 : knows(candidate,i) ; i for all others before candidate -> false
        // check 2 : knows(i,candidate) , i for all ohters -> true (double check)
        for(int i = 0 ; i < n ; i++){
            if(i<candidate && knows(candidate,i)) return -1;
            if(!knows(i,candidate)) return -1;
        }
        return candidate;
        
    }
}