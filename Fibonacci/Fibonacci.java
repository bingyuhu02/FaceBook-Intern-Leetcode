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