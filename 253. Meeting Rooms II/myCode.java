/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        Interval[] test = new Interval[3];
        test[0] = new Interval(1,2);
        test[1] = new Interval(0,3);
        test[2] = new Interval(0,4);
        
        myCode sol = new myCode();
        
        int res = sol.mostFrequentElement(test);
        System.out.print(res);


    
    }
    public int mostFrequentElement(Interval[] intervals){
        int max = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0 ; i < intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        // check
        int count = 0;
        int curEnd = 0;
        for( int i = 0 ; i < start.length ; i++){
            if( start[i] < end[curEnd]){
                count++;
                if( count > max ){
                    max = count;
                    res = start[i];
                }
            } else curEnd++;
        }
        return res;
    }    
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
