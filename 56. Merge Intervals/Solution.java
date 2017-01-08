/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// O(nlogn)
// O(n)
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // corner case checked 
        if( intervals.size() <= 1) return intervals;
        List<Interval> res = new LinkedList<>();
        // sort by starting point using an anonymous comparator
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.start,i2.start);
            }
        });
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals){
            // overlapping
            if(interval.start <= end) end = Math.max(end, interval.end);
            else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}