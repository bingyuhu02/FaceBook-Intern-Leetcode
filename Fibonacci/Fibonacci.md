# Fibonacci
## Recursion

### Time 
* O(n^2)

### Space O(1) without considering recursion stack O(n)

### Visulization 

```
                        fib(5)   
                     /             \     
               fib(4)                fib(3)   
             /      \                /     \
         fib(3)      fib(2)         fib(2)    fib(1)
        /     \        /    \       /    \  
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /    \
fib(1) fib(0)
```

### Code 

```
public class Fibonacci {
    public static long fibonacci(int n) {
    	if(n == 0 ) return 0;
        if(n == 1) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) System.out.println(i + ": " + fibonacci(i));
    }
}
```

## Follow up : O(n) + O(1) solution
### Code 

```
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
```