public class Solution{
	public static void main(String[] args){
		Solution sol  = new Solution();
		for(int i = 0 ;  i <= 20 ; i++){
			System.out.print(sol.fib(i) + ", ");
		}

	}
	private int fib(int n){
		int n1 = 0;
		int n2 = 1;
		if( n == 0 ) return n1;
		if( n == 1 ) return n2;
		for( int i = 2 ; i <= n ; i++){
			int res = n1 + n2;
			n1 = n2;
			n2 = res;	
		}
		return n2;
	} 
}