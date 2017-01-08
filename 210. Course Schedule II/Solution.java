public class Solution {
    public int[] findOrder(int numCourses, int[][] p) {
        if( numCourses == 0 ) return null;
        // // Convert graph presentation from edges to indegree of adjacent list.
        int list[] = new int[numCourses], res[] = new int[numCourses];
        int index = 0;
        for( int i = 0 ; i < p.length; i++){
            list[p[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for( int i = 0 ; i < numCourses; i++){
            if(list[i] == 0){
                res[index++] = i;
                queue.offer(i);
            }
        }
        // How many courses don't need preequisties
        while(!queue.isEmpty()){
            // Already finished this prerequisite course
            int requirment = queue.poll();
            for( int i = 0 ; i < p.length; i++){
                if( p[i][1] == requirment ){
                    list[p[i][0]]--;
                    if(list[p[i][0]] == 0){
                        // If indegree is zero, then add the course to the order.
                        res[index++] = p[i][0];
                        queue.offer(p[i][0]);
                    }
                }
            }
        }
        return (index == numCourses) ? res : new int[0];
    }
}