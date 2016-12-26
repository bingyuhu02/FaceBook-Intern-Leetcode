public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if( grid == null || grid.length == 0) return res;
        if( grid[0] == null || grid[0].length == 0 ) return res;
        int row = grid.length;
        int col = grid[0].length;
        for( int i = 0 ; i < row ; i ++) {
            for(int j = 0 ; j < col ; j++ ){
                if(grid[i][j] == '1'){
                    removeIsland(grid, row,col, i, j);
                    res++;   
                }
            }
        }
        return res;
        
    }
    private void removeIsland(char[][] grid, int row, int col, int x ,int y){
        grid[x][y] = '0';
        for(int i = -1 ; i <= 1 ; i++ ){
            for( int j = -1 ; j <= 1 ; j++ ){
                if(isValid(i,j,x,y,row,col) && grid[x+i][y+j] == '1'){
                    removeIsland(grid,row,col,x+i,y+j);
                }
            }
        }
    }
    private boolean isValid(int i , int j , int x , int y , int row , int col){
        return i+x >=0 && i+x < row && j+y >= 0 && j+y < col && Math.abs(i) != Math.abs(j);
    }
}



public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if( grid == null || grid.length == 0) return res;
        if( grid[0] == null || grid[0].length == 0 ) return res;
        int row = grid.length;
        int col = grid[0].length;
        for( int i = 0 ; i < row ; i ++) {
            for(int j = 0 ; j < col ; j++ ){
                if(grid[i][j] == '1'){
                    bfs(grid, row, col, i, j);
                    res++;   
                }
            }
        }
        return res;
       
    }
    public void bfs(char[][] grid, int m, int n, int x, int y){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(x*n+y);
        grid[x][y] = '0';
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int curX = cur/n;
            int curY = cur%n;
            for(int i = -1; i <= 1 ; i++ ){
                for(int j = -1 ; j <= 1; j++){
                    if( isValid(i, j, curX, curY, m, n) && grid[curX+i][curY+j] == '1'){
                        queue.offer((curX+i) * n + (curY+j));
                        grid[curX+i][curY+j] = '0'; 
                    }
                }
            }
        }
    }
    private boolean isValid(int i , int j , int x , int y , int row , int col){
        return i+x >=0 && i+x < row && j+y >= 0 && j+y < col && Math.abs(i) != Math.abs(j);
    }
}