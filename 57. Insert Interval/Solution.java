public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int index = 0;
        // add all the interval ending before new Interval starts
        while( index < intervals.size() && intervals.get(index).end < newInterval.start){
            res.add(intervals.get(index++));
        }
        // merger all overlapping intervals to one considering newIntervals
        while( index < intervals.size () && intervals.get(index).start <= newInterval.end){
            newInterval = new Interval(
                Math.min(newInterval.start, intervals.get(index).start),
                Math.max(newInterval.end, intervals.get(index).end));
            index++;
        }
        // add the uninon of intervals 
        res.add(newInterval);
        while( index < intervals.size() ) res.add(intervals.get(index++));
        return res;
    }
}