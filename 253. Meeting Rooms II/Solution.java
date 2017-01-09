public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int curEnd = 0; 
        for( int i = 0 ; i < start.length ; i++){
            if( start[i] < end[curEnd]) count++;
            else curEnd++;
        }
        return count;
    }
}