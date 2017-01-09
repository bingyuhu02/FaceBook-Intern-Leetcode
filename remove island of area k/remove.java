public class remove {
    public static void main(String[] args) {
        int[][] n = {
                {1,1,1,1,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {1,1,0,1,0},
        };
        remove sol = new remove();
        sol.solve(n,3);

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                System.out.print(n[i][j]);
            }
            System.out.println();
        }
    }

    int size = 0;

    public void solve(int[][] n, int k) {
        if (n == null || n.length == 0) return;
        if (n[0] == null || n[0].length == 0) return;
        int row = n.length;
        int col = n[0].length;
        int[][] temp = new int[row][col];

        for( int i = 0 ; i < row ; i++){
            for( int j = 0 ; j < col ; j++){
                temp[i][j] = n[i][j];
            }

        }

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                if (temp[i][j] == 1) {
                    size = 1;
                    int area = checkSize(temp,row,col,i,j);
                    if (area > k) {
                        size = 0;
                    }

                    if( area <= k ){
                        remove(n,row,col,i,j);
                    }
                }
            }
        }
    }
    private int checkSize(int[][] temp, int row, int col, int x, int y) {
        temp[x][y] = 0;
        for (int i = -1; i <= 1 ; i++) {
            for ( int j = - 1; j <= 1 ; j++ ){
                if( isValid( i , j , x , y , row , col ) && temp[x+i][y+j] == 1 ){
                    size++;
                    checkSize( temp , row , col , x+i, y+j);
                }
            }
        }
        return size;
    }
    public  void  remove(int[][] n, int row, int col, int x, int y){
        n[x][y] = 0;
        for(int i = -1 ; i <= 1 ; i++ ){
            for( int j = -1 ; j <= 1 ; j++ ){
                if(isValid(i,j,x,y,row,col) && n[x+i][y+j] == 1){
                    remove(n,row,col,x+i,y+j);
                }
            }
        }

    }
    private boolean isValid(int i , int j , int x , int y , int row , int col){
        return i+x >= 0 && i+x < row && j+y >= 0 && j+y < col;
    }
}
